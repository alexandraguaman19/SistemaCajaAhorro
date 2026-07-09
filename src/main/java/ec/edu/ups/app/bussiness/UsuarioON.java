package ec.edu.ups.app.bussiness;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.app.dao.UsuarioDao;
import ec.edu.ups.app.modelo.Usuario;

@Stateless
public class UsuarioON {

    @Inject
    private UsuarioDao usuarioDAO;

    public Usuario login(String usuario, String clave) {

        Usuario u = usuarioDAO.buscarUsuario(usuario);

        if (u == null) {
            return null;
        }

        if (u.getPassword().equals(clave)) {
            return u;
        }

        return null;
    }

}