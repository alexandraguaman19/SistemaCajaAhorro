package ec.edu.ups.app.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoTransaccion {

	@Id
	private int id;
	
	private String tipo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
