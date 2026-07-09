package ec.edu.ups.app.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cuota {

	@Id
	private int id;
	private double monto;
	private Date fechaVencimiento;
	private Date fechaPago;
	private String estado;
	private double montoInteres;
	private double montoPago;
	
	@OneToOne
	private Credito credito;
	
	
	
}
