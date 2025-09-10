package nmdc.nmdc.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="pago")
public class Pago {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(nullable=false)
    private BigDecimal costo;

    @Column(nullable=false)
    private String paquete;

    @Column(nullable=false)
    private LocalDate fechaPago;

    // Relación con Inscripciones
    @OneToMany(mappedBy = "pago", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripcion> inscripciones = new ArrayList<>();

    public Pago() {}

    public Pago(BigDecimal costo, String paquete, LocalDate fechaPago) {
        this.costo = costo;
        this.paquete = paquete;
        this.fechaPago = fechaPago;
    }

   
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public String getPaquete() {
		return paquete;
	}

	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	@Override
    public String toString() {
        return "Pago [id=" + id + ", costo=" + costo +
               ", paquete=" + paquete + ", fechaPago=" + fechaPago + "]";
    }
}

