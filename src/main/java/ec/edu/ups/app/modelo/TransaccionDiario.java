package ec.edu.ups.app.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TransaccionDiario {

	@Id
	private int id;
	private Date fecha;
	private String descripcion;
	private double debe;
	private double haber;
	@OneToOne
	private Cuota cuota;
	@OneToOne
	private AsientoContable asiento;
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
	public double getDebe() {
		return debe;
	}
	public void setDebe(double debe) {
		this.debe = debe;
	}
	public double getHaber() {
		return haber;
	}
	public void setHaber(double haber) {
		this.haber = haber;
	}
	public AsientoContable getAsiento() {
		return asiento;
	}
	public void setAsiento(AsientoContable asiento) {
		this.asiento = asiento;
	}
	
	
	
	
	
}

