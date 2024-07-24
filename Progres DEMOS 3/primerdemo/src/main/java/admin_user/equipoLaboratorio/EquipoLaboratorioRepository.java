package admin_user.equipoLaboratorio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipoLaboratorioRepository extends JpaRepository<EquipoLaboratorio, Integer> {
    Optional<EquipoLaboratorio> findByNombre(String nombre);
}
