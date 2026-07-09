package ec.edu.ups.app.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ec.edu.ups.app.modelo.Usuario;


@Stateless
public class UsuarioDao {
	
	private EntityManager em;

	public Usuario buscarUsuario(String usuario) {

	    String jpql = "SELECT u FROM Usuario u WHERE u.usuario=:usuario";

	    List<Usuario> lista = em.createQuery(jpql, Usuario.class)
	            .setParameter("usuario", usuario)
	            .getResultList();

	    if (lista.isEmpty())
	        return null;

	    return lista.get(0);

	}
	
}
