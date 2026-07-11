package ec.edu.ups.app.bean;

import ec.edu.ups.app.bussiness.TransaccionON;
import ec.edu.ups.app.modelo.Transaccion;

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
public class TransaccionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TransaccionON transaccionON;

    private Transaccion transaccion;

    private List<Transaccion> listaTransacciones;

    @PostConstruct
    public void init() {
        nuevo();
        listar();
    }

    /**
     * Guarda o actualiza una transacción
     */
    public void guardar() {

        try {

            transaccionON.guardar(transaccion);

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Correcto",
                            "Transacción registrada correctamente."));

            nuevo();
            listar();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            e.getMessage()));

        }

    }

    /**
     * Carga la transacción seleccionada para editar.
     */
    public void editar(Transaccion transaccion) {

        this.transaccion = transaccion;

    }

    /**
     * Elimina una transacción.
     */
    public void eliminar(Transaccion transaccion) {

        try {

            transaccionON.eliminar(transaccion.getId());

            listar();

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Correcto",
                            "Transacción eliminada correctamente."));

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            e.getMessage()));

        }

    }

    /**
     * Busca una transacción por ID.
     */
    public void buscar() {

        if (transaccion.getId() != 0) {

            transaccion = transaccionON.buscar(transaccion.getId());

            if (transaccion == null) {

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Aviso",
                                "No se encontró la transacción."));

                nuevo();

            }

        }

    }

    /**
     * Lista todas las transacciones.
     */
    public void listar() {

        listaTransacciones = transaccionON.listar();

    }

    /**
     * Limpia el formulario.
     */
    public void nuevo() {

        transaccion = new Transaccion();

    }

    //===========================
    // Getters y Setters
    //===========================

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

}