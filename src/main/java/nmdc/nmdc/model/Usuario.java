package nmdc.nmdc.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private Long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String apellido;
	@Column(nullable=false)
	private String telefono;
	@Column(nullable=false)
	private String correo;
	@Column(nullable=false)
	private String fechaRegistro;
	
	public Usuario(String nombre, String apellido, String telefono, String correo, String fechaRegistro) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.correo = correo;
		this.fechaRegistro = fechaRegistro;
		//Usuario.total++;
		//this.id=Usuario.total;
	}//constructor
	public Usuario() {
		//Usuario.total++;
		//this.id=Usuario.total;
	}//constructor vacio
	public Long getId() {
		return id;
	}//getid
	public void setId(Long id) {
		this.id = id;
	}//setid
	public String getNombre() {
		return nombre;
	}//getnombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}//getter and setter
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono
				+ ", correo=" + correo + ", fechaRegistro=" + fechaRegistro + "]";
	}//toString
}
