package nmdc.nmdc.model;

import javax.persistence.*;

@Entity
@Table(name="clases")
public class Clases {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private Long id;
	@Column(nullable=false)
	private String imagen;
	@Column(nullable=false)
	private String nombreClases;
	@Column(nullable=false)
	private String edadAdmision;
	@Column(nullable=false)
	private String maestro;
	@Column(nullable=false)
	private String horario;
	@Column(nullable=false)
	private String claseSuelta;
	@Column(nullable=false)
	private String inscripcion;
	public Clases(Long id, String imagen, String nombreClases, String edadAdmision, String maestro, String horario,
			String claseSuelta, String inscripcion) {
		super();
		this.id = id;
		this.imagen = imagen;
		this.nombreClases = nombreClases;
		this.edadAdmision = edadAdmision;
		this.maestro = maestro;
		this.horario = horario;
		this.claseSuelta = claseSuelta;
		this.inscripcion = inscripcion;
	}
	public Clases() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getNombreClases() {
		return nombreClases;
	}
	public void setNombreClases(String nombreClases) {
		this.nombreClases = nombreClases;
	}
	public String getEdadAdmision() {
		return edadAdmision;
	}
	public void setEdadAdmision(String edadAdmision) {
		this.edadAdmision = edadAdmision;
	}
	public String getMaestro() {
		return maestro;
	}
	public void setMaestro(String maestro) {
		this.maestro = maestro;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getClaseSuelta() {
		return claseSuelta;
	}
	public void setClaseSuelta(String claseSuelta) {
		this.claseSuelta = claseSuelta;
	}
	public String getInscripcion() {
		return inscripcion;
	}
	public void setInscripcion(String inscripcion) {
		this.inscripcion = inscripcion;
	}
	@Override
	public String toString() {
		return "Clases [id=" + id + ", imagen=" + imagen + ", nombreClases=" + nombreClases + ", edadAdmision="
				+ edadAdmision + ", maestro=" + maestro + ", horario=" + horario + ", claseSuelta=" + claseSuelta
				+ ", inscripcion=" + inscripcion + "]";
	}
	
	
	}
	
	

