package nmdc.nmdc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nmdc.nmdc.model.UsuarioRegistrado;

public interface UsuarioRegistradoRepository extends JpaRepository <UsuarioRegistrado, Long>{
Optional <UsuarioRegistrado>findByCorreo(String correo);
}
