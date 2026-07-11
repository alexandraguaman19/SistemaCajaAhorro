package ec.edu.ups.app.bussiness;

import ec.edu.ups.app.dao.UsuarioDao;
import ec.edu.ups.app.modelo.Usuario;

import javax.ejb.Stateless;
import javax.inject.Inject;

import java.util.List;

@Stateless
public class UsuarioON {

    @Inject
    private UsuarioDao usuarioDAO;

    public void guardar(Usuario usuario) throws Exception {

        Usuario existe = usuarioDAO.buscarUsername(usuario.getUsername());

        if (usuario.getCodigo() == 0 && existe != null) {
            throw new Exception("El usuario ya existe.");
        }

        if (usuario.getCodigo() == 0)
            usuarioDAO.insert(usuario);
        else
            usuarioDAO.update(usuario);

    }

    public void eliminar(int codigo) {

        usuarioDAO.delete(codigo);

    }

    public Usuario buscar(int codigo) {

        return usuarioDAO.read(codigo);

    }

    public List<Usuario> listar() {

        return usuarioDAO.getAll();

    }

    public Usuario login(String username, String password) {

        return usuarioDAO.login(username, password);

    }

}