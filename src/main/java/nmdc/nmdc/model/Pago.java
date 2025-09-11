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
	@Column(name="id",unique=true,nullable=false)
	private Long id;
	@Column(nullable=false)
	private String costo;
	@Column(nullable=false)
	private String paquete;
	@Column(nullable=false)
	private String fechaPago;
	
	
	public Pago(String costo, String paquete,String fechaPago) {
		super();
		this.costo = costo;
		this.paquete= paquete;
		this.fechaPago = fechaPago;
		//Pago.total++;
		//this.id=Pago.total;
	}
	public Pago() {
		//Pago.total++;
		//this.id=Pago.total;
		
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}
	public String getPaquete() {
		return paquete;
	}
	public void setPaquete(String paquete) {
		this.paquete = paquete;
	}
	public String getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Pago [id=" + id + ", costo=" + costo + ", paquete=" + paquete + ", fechaPago=" + fechaPago + "]";
	}

	
}

