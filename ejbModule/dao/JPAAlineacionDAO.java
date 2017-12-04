package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import modelo.Alineacion;
import modelo.Color;
import modelo.Partido;
import modelo.Usuario;

public class JPAAlineacionDAO implements AlineacionDAO {

	EntityManagerFactory emf;

	public JPAAlineacionDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Alineacion createAlineacion(String nombre, Color color, int tanteo, Long partido) throws DAOException {
		EntityManager em = null;

		synchronized (emf) {
			em = emf.createEntityManager();
		}

		Alineacion ali = new Alineacion();
		Partido par = em.find(Partido.class, partido);
		
		ali.setColor(color);
		ali.setNombre(nombre);
		ali.setTanteo(tanteo);
		ali.setPartido(par);
		
		par.getAlineaciones().add(ali);

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(ali);
		tx.commit();
		em.close();

		return ali;
	}

	@Override
	public Alineacion addUsuario(String alineacion, String usuario) throws DAOException {
		EntityManager em = null;

		synchronized (emf) {
			em = emf.createEntityManager();
		}

		Alineacion ali = em.find(Alineacion.class, alineacion);
		Usuario usu = em.find(Usuario.class, usuario);
		
		ali.getUsuarios().add(usu);
		usu.getAlineaciones().add(ali);

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(ali);
		em.persist(usu);

		tx.commit();
		em.close();

		return ali;
	}

}
