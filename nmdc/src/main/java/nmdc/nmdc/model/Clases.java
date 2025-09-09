package nmdc.nmdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clases")
public class Clases {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private Long id;
	@Column(nullable=false)
	private String nombreClases;
	@Column(nullable=false)
	private String ededAdmision;
	@Column(nullable=false)
	private String horario;
	
	public Clases(String nombreClases, String ededAdmision, String horario) {
		super();
		this.nombreClases = nombreClases;
		this.ededAdmision = ededAdmision;
		this.horario = horario;
		//Clases.total++;
		//this.id=Clases.total;
	}//constructor
	
	public Clases() {
		//Clases.total++;
		//this.id=Clases.total;
	}//constructor vacio
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreClases() {
		return nombreClases;
	}
	public void setNombreClases(String nombreClases) {
		this.nombreClases = nombreClases;
	}
	public String getEdedAdmision() {
		return ededAdmision;
	}
	public void setEdedAdmision(String ededAdmision) {
		this.ededAdmision = ededAdmision;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Clases [id=" + id + ", nombreClases=" + nombreClases + ", ededAdmision=" + ededAdmision + ", horario="
				+ horario + "]";
	}//toString

}//class
