package nmdc.nmdc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="usuarioregistrado")
public class UsuarioRegistrado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true,nullable=false)
	private long id;
	@Column(nullable=false)
	private String correo;
	@Column(nullable=false)
	private String contrasena;
	public UsuarioRegistrado(long id, String correo, String contrasena) {
		super();
		this.id = id;
		this.correo = correo;
		this.contrasena = contrasena;
	}//constructor
	public UsuarioRegistrado() {
		
	}//constructor vacio
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	@Override
	public String toString() {
		return "UsuarioRegistrado [id=" + id + ", correo=" + correo + ", contrasena=" + contrasena + "]";
	}
	
}
