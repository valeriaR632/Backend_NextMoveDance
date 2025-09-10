package nmdc.nmdc.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="inscripcion")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(nullable=false)
    private LocalDate fechaInscripcion;

    // FK hacia Usuario
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    // FK hacia Clases
    @ManyToOne
    @JoinColumn(name = "clase_id", nullable = false)
    private Clases clase;

    // FK hacia Pago
    @ManyToOne
    @JoinColumn(name = "pago_id", nullable = true)
    private Pago pago;

    public Inscripcion() {}

    public Inscripcion(LocalDate fechaInscripcion, Usuario usuario, Clases clase, Pago pago) {
        this.fechaInscripcion = fechaInscripcion;
        this.usuario = usuario;
        this.clase = clase;
        this.pago = pago;
    }

    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Clases getClase() {
		return clase;
	}

	public void setClase(Clases clase) {
		this.clase = clase;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	@Override
    public String toString() {
        return "Inscripcion [id=" + id + ", fechaInscripcion=" + fechaInscripcion +
               ", usuario=" + (usuario != null ? usuario.getNombre() : "null") +
               ", clase=" + (clase != null ? clase.getNombreClase() : "null") +
               ", pago=" + (pago != null ? pago.getId() : "null") + "]";
    }
}
