package admin_user.backup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/backup")
public class BackupController {

    @Autowired
    private BackupService backupService;

    @GetMapping
    public String backupDatabase() {
        try {
            String backupFile = backupService.backupDatabase();
            return "Backup realizado con éxito! Archivo: " + backupFile;
        } catch (IOException e) {
            return "Error al realizar el backup: " + e.getMessage();
        }
    }
}