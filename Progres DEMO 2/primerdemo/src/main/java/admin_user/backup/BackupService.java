package admin_user.backup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BackupService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String BACKUP_PATH = "D:/Others/SGRH Backup"; // Cambia esta ruta a donde quieras guardar el respaldo
    private static final String DATABASE_NAME = "recursos";

    public String backupDatabase() throws IOException {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String backupFile = BACKUP_PATH + "/" + DATABASE_NAME + "_backup_" + timestamp + ".sql";
        try (FileWriter fileWriter = new FileWriter(backupFile)) {
            List<String> tables = getTables();
            for (String table : tables) {
                exportTable(table, fileWriter);
            }
            return backupFile;
        } catch (SQLException e) {
            throw new IOException("Error while accessing the database: " + e.getMessage(), e);
        }
    }

    private List<String> getTables() {
        return jdbcTemplate.query("SHOW TABLES", (ResultSet rs, int rowNum) -> rs.getString(1));
    }

    private void exportTable(String tableName, FileWriter fileWriter) throws SQLException, IOException {
        fileWriter.write("DROP TABLE IF EXISTS " + tableName + ";\n");
        fileWriter.write(getCreateTableStatement(tableName) + ";\n");

        jdbcTemplate.query("SELECT * FROM " + tableName, rs -> {
            StringBuilder insertStatement = new StringBuilder("INSERT INTO " + tableName + " VALUES (");
            int columnCount = rs.getMetaData().getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                Object value = rs.getObject(i);
                if (value == null) {
                    insertStatement.append("NULL");
                } else if (value instanceof String || value instanceof java.sql.Date || value instanceof java.sql.Timestamp) {
                    insertStatement.append("'").append(value.toString().replace("'", "''")).append("'");
                } else {
                    insertStatement.append(value);
                }
                if (i < columnCount) {
                    insertStatement.append(", ");
                }
            }
            insertStatement.append(");");

            try {
                fileWriter.write(insertStatement.toString());
                fileWriter.write("\n"); // Añadir una nueva línea después de cada declaración de inserción
            } catch (IOException e) {
                throw new SQLException("Error writing to file", e);
            }
        });
    }

    private String getCreateTableStatement(String tableName) {
        return jdbcTemplate.queryForObject("SHOW CREATE TABLE " + tableName, (ResultSet rs, int rowNum) -> rs.getString(2));
    }
}
