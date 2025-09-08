package nmdc.nmdc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nmdc.nmdc.model.Pago;



@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
Optional<Pago>findByFechaPago(String fechaPago);
}
