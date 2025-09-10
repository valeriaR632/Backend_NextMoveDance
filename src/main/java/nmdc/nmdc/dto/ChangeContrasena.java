package nmdc.nmdc.dto;

public class ChangeContrasena {
	private String Contrasena;
	private String ncontrasena;
	public ChangeContrasena(String contrasena, String ncontrasena) {
		super();
		Contrasena = contrasena;
		this.ncontrasena = ncontrasena;
	}//constructor
	public ChangeContrasena() {
		
	}//constructorvasio
	public String getContrasena() {
		return Contrasena;
	}
	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}
	public String getNcontrasena() {
		return ncontrasena;
	}
	public void setNcontrasena(String ncontrasena) {
		this.ncontrasena = ncontrasena;
	}
	@Override
	public String toString() {
		return "ChangeContrasena [Contrasena=" + Contrasena + ", ncontrasena=" + ncontrasena + "]";
	}
	
	

}
