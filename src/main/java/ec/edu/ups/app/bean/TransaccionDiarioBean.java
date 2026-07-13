package ec.edu.ups.app.bean;

import ec.edu.ups.app.bussiness.TransaccionDiarioON;
import ec.edu.ups.app.modelo.TransaccionDiario;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class TransaccionDiarioBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TransaccionDiarioON transaccionDiarioON;

    private TransaccionDiario transaccion;

    private List<TransaccionDiario> listaTransacciones;

    @PostConstruct
    public void init() {

        nuevo();
        listar();

    }

    public void guardar() {

        try {

            transaccionDiarioON.guardar(transaccion);

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Correcto",
                            "Movimiento registrado correctamente."));

            nuevo();
            listar();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Error",
                            e.getMessage()));

        }

    }

    public void editar(TransaccionDiario transaccion) {

        this.transaccion = transaccion;

    }

    public void eliminar(TransaccionDiario transaccion) {

        try {

            transaccionDiarioON.eliminar(transaccion.getId());

            listar();

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Correcto",
                            "Movimiento eliminado."));

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Error",
                            e.getMessage()));

        }

    }

    public void buscar() {

        if (transaccion.getId() != 0) {

            transaccion = transaccionDiarioON.buscar(transaccion.getId());

            if (transaccion == null) {

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(
                                FacesMessage.SEVERITY_WARN,
                                "Aviso",
                                "No se encontró la transacción."));

                nuevo();

            }

        }

    }

    public void listar() {

        listaTransacciones = transaccionDiarioON.listar();

    }

    public void nuevo() {

        transaccion = new TransaccionDiario();

    }

    //=====================
    // Getters y Setters
    //=====================

    public TransaccionDiario getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(TransaccionDiario transaccion) {
        this.transaccion = transaccion;
    }

    public List<TransaccionDiario> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<TransaccionDiario> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

}