package ec.edu.ups.app.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import ec.edu.ups.app.modelo.Socio;

public class SocioDao implements Serializable{

    @Inject
    private EntityManager em;

    public void insertar(Socio socio){
        em.persist(socio);
    }

    public void actualizar(Socio socio){
        em.merge(socio);
    }

    public void eliminar(int id){
        Socio s=em.find(Socio.class,id);
        if(s!=null)
            em.remove(s);
    }

    public Socio buscar(int id){
        return em.find(Socio.class,id);
    }

    public List<Socio> listar(){
        return em.createQuery("SELECT s FROM Socio s",Socio.class).getResultList();
    }

    public Socio buscarCedula(String cedula){

        String jpql="SELECT s FROM Socio s WHERE s.cedula=:cedula";

        TypedQuery<Socio> query=em.createQuery(jpql,Socio.class);

        query.setParameter("cedula",cedula);

        return query.getSingleResult();

    }

}
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import ec.edu.ups.app.modelo.Persona;
import ec.edu.ups.app.modelo.Socio;

public class SocioDao implements Serializable {

	    private static final long serialVersionUID = 1L;
	    @Inject
	    private EntityManager em;

	    public void guardar(Socio socio) {
	        em.persist(socio);
	    }

	    public void actualizar(Socio socio) {
	        em.merge(socio);
	    }

	    public Socio buscarPorId(int id) {
	        return em.find(Socio.class, id);
	    }

	    public List<Socio> listar() {
	        TypedQuery<Socio> query = em.createQuery(
	                "SELECT s FROM Socio s", Socio.class);
	        return query.getResultList();
	    }
    
	    public Socio buscarPorCedula(String cedula) {
	        try {
	            return em.createQuery(
	                    "SELECT s FROM Socio s WHERE s.cedula = :cedula",
	                    Socio.class)
	                    .setParameter("cedula", cedula)
	                    .getSingleResult();
	        } catch (NoResultException e) {
	            return null;
	        }
	    }

	
}
