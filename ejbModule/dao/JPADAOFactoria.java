package dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPADAOFactoria extends DAOFactoria{

	private EntityManagerFactory emf;
	
	public JPADAOFactoria(){
		emf = Persistence.createEntityManagerFactory("PracticaFinal");
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		
		return new JPAUsuarioDAO(this.emf);
	}

	
	@Override
	public PartidoDAO getPartidoDAO() {
		return new JPAPartidoDAO(this.emf);
	}
	
	@Override
	public TemporadaDAO getTemporadaDAO() {
		return new JPATemporadaDAO(this.emf);
	}
	
}
