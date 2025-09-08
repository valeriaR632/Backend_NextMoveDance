package nmdc.nmdc.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="inscripcion")
public class Inscripcion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private Long id;
	@Column(nullable=false)
	private LocalDate fechaInscripcion;
	
	
	public Inscripcion(LocalDate fechaInscripcion) {
		super();
		this.fechaInscripcion = fechaInscripcion;
		//Inscripcion.total++;
		//this.id = Inscripcion.total;
	}
	public Inscripcion() {
		//Inscripcion.total++;
		//this.id = Inscripcion.total;
	}
	public LocalDate getFechaInscripcion() {
		return fechaInscripcion;
	}
	public void setFechaInscripcion(LocalDate fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Inscripcion [id=" + id + ", fechaInscripcion=" + fechaInscripcion + "]";
	}

}
