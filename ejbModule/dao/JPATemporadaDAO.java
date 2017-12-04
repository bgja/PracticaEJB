package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import modelo.Temporada;
import modelo.Usuario;

public class JPATemporadaDAO implements TemporadaDAO {

	private EntityManagerFactory emf;

	public JPATemporadaDAO(EntityManagerFactory emf) {
		this.emf = emf;
	}

	@Override
	public Temporada createTemporada(String nombre, String lugar, int minimo) throws DAOException {

		EntityManager em = null;

		synchronized (emf) {
			em = emf.createEntityManager();
		}

		Temporada temp = new Temporada();
		temp.setNombre(nombre);
		temp.setLugar(lugar);
		temp.setMinimo(minimo);

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(temp);
		tx.commit();
		em.close();

		return temp;
	}

	@Override
	public Temporada findTemporada(String nombre) throws DAOException {
		EntityManager em = null;

		synchronized (emf) {
			em = emf.createEntityManager();
		}

		Temporada temp = em.find(Temporada.class, nombre);

		em.close();

		return temp;
	}

	@Override
	public Temporada addUsuarioTemporada(String temporada, String usuario) {
		EntityManager em = null;

		synchronized (emf) {
			em = emf.createEntityManager();
		}

		Temporada temp = em.find(Temporada.class, temporada);
		Usuario usu = em.find(Usuario.class, usuario);
		
		temp.getUsuarios().add(usu);
		usu.getTemporadas().add(temp);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		
		em.persist(temp);
		em.persist(usu);
		
		tx.commit();
		em.close();
		
		return temp;
		
	}

	@Override
	public Temporada deleteUsuarioTemporada(String temporada, String usuario) throws DAOException {
		EntityManager em = null;

		synchronized (emf) {
			em = emf.createEntityManager();
		}

		Temporada temp = em.find(Temporada.class, temporada);
		Usuario usu = em.find(Usuario.class, usuario);
		
		temp.getUsuarios().remove(usu);
		usu.getTemporadas().remove(temp);

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(temp);
		em.persist(usu);
		
		tx.commit();
		em.close();
		
		return temp;
	}

	public List<Temporada> findAllTemporadas(){
		EntityManager em = null;

		synchronized (emf) {
			em = emf.createEntityManager();
		}
		
		Query query = em.createNamedQuery("findAllTemporadas");
		return query.getResultList();
	}
}
