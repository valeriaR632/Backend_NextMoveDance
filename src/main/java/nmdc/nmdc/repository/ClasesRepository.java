package nmdc.nmdc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nmdc.nmdc.model.Clases;
import nmdc.nmdc.model.Usuario;
@Repository
public interface ClasesRepository extends JpaRepository<Clases, Long>{
	Optional<Clases>findByNombreClases(String nombreClases);
}
