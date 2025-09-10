package nmdc.nmdc.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="maestros")
public class Maestros {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @Column(nullable=false)
    private String nombre;

    @Column(nullable=false)
    private String apellido;

    @Column(nullable=false)
    private String telefono;

    @Column(nullable=false)
    private String redSocial;

    // Relación con Clases
    @OneToMany(mappedBy = "maestro", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Clases> clases = new ArrayList<>();

    public Maestros() {}

    public Maestros(String nombre, String apellido, String telefono, String redSocial) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.redSocial = redSocial;
    }

    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

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

	public String getRedSocial() {
		return redSocial;
	}

	public void setRedSocial(String redSocial) {
		this.redSocial = redSocial;
	}

	public List<Clases> getClases() {
		return clases;
	}

	public void setClases(List<Clases> clases) {
		this.clases = clases;
	}

	@Override
    public String toString() {
        return "Maestros [id=" + id + ", nombre=" + nombre +
               ", apellido=" + apellido + ", telefono=" + telefono +
               ", redSocial=" + redSocial + "]";
    }
}
