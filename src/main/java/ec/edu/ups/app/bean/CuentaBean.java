package ec.edu.ups.app.bean;

import ec.edu.ups.app.bussiness.CuentaON;
import ec.edu.ups.app.modelo.Cuenta;

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
public class CuentaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private CuentaON cuentaON;

    private Cuenta cuenta;

    private List<Cuenta> listaCuentas;

    @PostConstruct
    public void init() {
        cuenta = new Cuenta();
        listar();
    }

    public void guardar() {

        try {

            cuentaON.guardar(cuenta);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Correcto",
                            "Cuenta guardada correctamente"));

            nuevo();

            listar();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            e.getMessage()));

        }

    }

    public void editar(Cuenta cuenta) {

        this.cuenta = cuenta;

    }

    public void eliminar(Cuenta cuenta) {

        try {

            cuentaON.eliminar(cuenta.getId());

            listar();

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Correcto",
                            "Cuenta eliminada"));

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error",
                            e.getMessage()));

        }

    }

    public void buscar() {

        if (cuenta.getId() != 0) {

            cuenta = cuentaON.buscar(cuenta.getId());

        }

    }

    public void listar() {

        listaCuentas = cuentaON.listar();

    }

    public void nuevo() {

        cuenta = new Cuenta();

    }

    //===========================
    // Getters & Setters
    //===========================

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

}