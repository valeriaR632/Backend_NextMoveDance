package nmdc.nmdc.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="clases")
public class Clases {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(nullable=false)
    private String nombreClase;

    @Column(nullable=false)
    private String edadAdmision;

    @Column(nullable=false)
    private String horario;

    // FK hacia Maestros
    @ManyToOne
    @JoinColumn(name = "maestro_id", nullable = false)
    private Maestros maestro;

    // Relación con Inscripciones
    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripcion> inscripciones = new ArrayList<>();

    public Clases() {}

    public Clases(String nombreClase, String edadAdmision, String horario, Maestros maestro) {
        this.nombreClase = nombreClase;
        this.edadAdmision = edadAdmision;
        this.horario = horario;
        this.maestro = maestro;
    }

   

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreClase() {
		return nombreClase;
	}

	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}

	public String getEdadAdmision() {
		return edadAdmision;
	}

	public void setEdadAdmision(String edadAdmision) {
		this.edadAdmision = edadAdmision;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Maestros getMaestro() {
		return maestro;
	}

	public void setMaestro(Maestros maestro) {
		this.maestro = maestro;
	}

	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	@Override
    public String toString() {
        return "Clases [id=" + id + ", nombreClase=" + nombreClase +
               ", edadAdmision=" + edadAdmision + ", horario=" + horario + "]";
    }
}
