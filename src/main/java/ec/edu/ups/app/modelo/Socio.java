package ec.edu.ups.app.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Socio {

	@Id
	private int id;
	private String direccion;
	private String telefono;
	private Date fechaNac;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	
	
}
