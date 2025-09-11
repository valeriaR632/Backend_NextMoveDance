package nmdc.nmdc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nmdc.nmdc.model.Maestros;


@Repository
public interface MaestrosRepository extends JpaRepository<Maestros, Long> {
	Optional<Maestros>findByNombre(String nombre);
}
