package nmdc.nmdc.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nmdc.nmdc.model.Inscripcion;


@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
	Optional<Inscripcion>findByFechaInscripcion(LocalDate fechaInscripcion);
}
