package ec.edu.ups.app.bean;

import ec.edu.ups.app.bussiness.UsuarioON;
import ec.edu.ups.app.modelo.Usuario;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UsuarioBean implements Serializable {

    @Inject
    private UsuarioON usuarioON;

    private Usuario usuario;

    private List<Usuario> usuarios;

    @PostConstruct
    public void init() {

        usuario = new Usuario();

        listar();

    }

    public void guardar() {

        try {

            usuarioON.guardar(usuario);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Usuario guardado correctamente"));

            usuario = new Usuario();

            listar();

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Error", e.getMessage()));

        }

    }

    public void editar(Usuario usuario) {

        this.usuario = usuario;

    }

    public void eliminar(Usuario usuario) {

        usuarioON.eliminar(usuario.getCodigo());

        listar();

    }

    public void listar() {

        usuarios = usuarioON.listar();

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

}