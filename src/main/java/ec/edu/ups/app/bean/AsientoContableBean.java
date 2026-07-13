package ec.edu.ups.app.bean;

import ec.edu.ups.app.bussiness.AsientoContableON;
import ec.edu.ups.app.modelo.AsientoContable;

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
public class AsientoContableBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private AsientoContableON asientoON;

    private AsientoContable asiento;

    private List<AsientoContable> listaAsientos;

    @PostConstruct
    public void init() {
        nuevo();
        listar();
    }

    public void guardar() {

        try {

            asientoON.guardar(asiento);

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Correcto",
                            "Asiento Contable guardado correctamente"));

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

    public void editar(AsientoContable asiento) {

        this.asiento = asiento;

    }

    public void eliminar(AsientoContable asiento) {

        try {

            asientoON.eliminar(asiento.getId());

            listar();

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Correcto",
                            "Asiento eliminado"));

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

        if (asiento.getId() != 0) {

            asiento = asientoON.buscar(asiento.getId());

            if (asiento == null) {

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(
                                FacesMessage.SEVERITY_WARN,
                                "Aviso",
                                "No existe el asiento."));

                nuevo();

            }

        }

    }

    public void listar() {

        listaAsientos = asientoON.listar();

    }

    public void nuevo() {

        asiento = new AsientoContable();

    }

    //====================
    // Getters y Setters
    //====================

    public AsientoContable getAsiento() {
        return asiento;
    }

    public void setAsiento(AsientoContable asiento) {
        this.asiento = asiento;
    }

    public List<AsientoContable> getListaAsientos() {
        return listaAsientos;
    }

    public void setListaAsientos(List<AsientoContable> listaAsientos) {
        this.listaAsientos = listaAsientos;
    }

}