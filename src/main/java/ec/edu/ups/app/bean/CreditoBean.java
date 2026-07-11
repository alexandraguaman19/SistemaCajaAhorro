package ec.edu.ups.app.bean;

import ec.edu.ups.app.bussiness.CreditoON;
import ec.edu.ups.app.modelo.Credito;

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
public class CreditoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CreditoON creditoON;

    private Credito credito;

    private List<Credito> listaCreditos;

    @PostConstruct
    public void init() {
        nuevo();
        listar();
    }

    /**
     * Guarda o actualiza un crédito.
     */
    public void guardar() {

        try {

            creditoON.guardar(credito);

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Correcto",
                            "Crédito guardado correctamente."));

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
     * Selecciona un crédito para editar.
     */
    public void editar(Credito credito) {

        this.credito = credito;

    }

    /**
     * Elimina un crédito.
     */
    public void eliminar(Credito credito) {

        try {

            creditoON.eliminar(credito.getId());

            listar();

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(
                            FacesMessage.SEVERITY_INFO,
                            "Correcto",
                            "Crédito eliminado correctamente."));

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
     * Busca un crédito por ID.
     */
    public void buscar() {

        if (credito.getId() != 0) {

            credito = creditoON.buscar(credito.getId());

            if (credito == null) {

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(
                                FacesMessage.SEVERITY_WARN,
                                "Aviso",
                                "No existe el crédito solicitado."));

                nuevo();

            }

        }

    }

    /**
     * Lista todos los créditos.
     */
    public void listar() {

        listaCreditos = creditoON.listar();

    }

    /**
     * Limpia el formulario.
     */
    public void nuevo() {

        credito = new Credito();

    }

    //=========================
    // Getters y Setters
    //=========================

    public Credito getCredito() {
        return credito;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    public List<Credito> getListaCreditos() {
        return listaCreditos;
    }

    public void setListaCreditos(List<Credito> listaCreditos) {
        this.listaCreditos = listaCreditos;
    }

}