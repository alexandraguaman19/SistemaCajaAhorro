package ec.edu.ups.app.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transaccion {

	@Id
	private int id;
	private Date fecha;
	private double monto;
	@OneToOne
	private Cuenta cuenta;
	@OneToOne
	private TipoTransaccion tipo;
	
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
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public TipoTransaccion getTipo() {
		return tipo;
	}
	public void setTipo(TipoTransaccion tipo) {
		this.tipo = tipo;
	}
	
	
	
}
