package ec.edu.ups.app.bean;

import ec.edu.ups.app.bussiness.TipoTransaccionON;
import ec.edu.ups.app.modelo.TipoTransaccion;

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
public class TipoTransaccionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private TipoTransaccionON tipoTransaccionON;

    private TipoTransaccion tipoTransaccion;

    private List<TipoTransaccion> listaTipos;

    @PostConstruct
    public void init() {
        nuevo();
        listar();
    }

    /**
     * Guarda o actualiza un tipo de transacción
     */
    public void guardar() {

        try {

            tipoTransaccionON.guardar(tipoTransaccion);

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Correcto",
                            "Tipo de transacción guardado correctamente."));

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

    /**
     * Selecciona un registro para editar.
     */
    public void editar(TipoTransaccion tipo) {

        this.tipoTransaccion = tipo;

    }

    /**
     * Elimina un registro.
     */
    public void eliminar(TipoTransaccion tipo) {

        try {

            tipoTransaccionON.eliminar(tipo.getId());

            listar();

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Correcto",
                            "Tipo de transacción eliminado correctamente."));

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_ERROR,
                            "Error",
                            e.getMessage()));

        }

    }

    /**
     * Busca un registro por ID.
     */
    public void buscar() {

        if (tipoTransaccion.getId() != 0) {

            tipoTransaccion = tipoTransaccionON.buscar(tipoTransaccion.getId());

            if (tipoTransaccion == null) {

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(
                                FacesMessage.SEVERITY_WARN,
                                "Aviso",
                                "No se encontró el tipo de transacción."));

                nuevo();

            }

        }

    }

    /**
     * Lista todos los registros.
     */
    public void listar() {

        listaTipos = tipoTransaccionON.listar();

    }

    /**
     * Limpia el formulario.
     */
    public void nuevo() {

        tipoTransaccion = new TipoTransaccion();

    }

    //=========================
    // Getters & Setters
    //=========================

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public List<TipoTransaccion> getListaTipos() {
        return listaTipos;
    }

    public void setListaTipos(List<TipoTransaccion> listaTipos) {
        this.listaTipos = listaTipos;
    }

}