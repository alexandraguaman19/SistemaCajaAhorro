package ec.edu.ups.app.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AsientoContable {

	@Id
	private int id;
	private Date fecha;
	private String descripcion;
	private double totalDebe;
	private double totalHaber;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getTotalDebe() {
		return totalDebe;
	}
	public void setTotalDebe(double totalDebe) {
		this.totalDebe = totalDebe;
	}
	public double getTotalHaber() {
		return totalHaber;
	}
	public void setTotalHaber(double totalHaber) {
		this.totalHaber = totalHaber;
	}
	
	
	
}
