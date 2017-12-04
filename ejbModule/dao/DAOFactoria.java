package dao;

import dao.AlineacionDAO;
import dao.TemporadaDAO;

//Define una factoria abstracta que devuelve todos los DAO de la aplicacion
public class DAOFactoria {
	// Metodos factoria
	public UsuarioDAO getUsuarioDAO(){return null;}
	
	public PartidoDAO getPartidoDAO(){return null;}

	public TemporadaDAO getTemporadaDAO() {	return null;}
	
	public AlineacionDAO getAlineacionDAO() {return null;}
	
	// Declaracion como constantes de los tipos de factoria
	public final static int JDBC = 1;
	public final static int JPA = 2;

	private static DAOFactoria unicaInstancia;
	
	protected DAOFactoria(){
		
	}
	
	
	public static void setDAOFActoria(int tipo) throws DAOException{
		switch (tipo) {
			case JDBC: {
				try {
					unicaInstancia = new JDBCDAOFactoria();
				} catch (Exception e) {
					throw new DAOException(e.getMessage());
				}
			}
			
			case JPA: {
				try {
					unicaInstancia = new JPADAOFactoria();
				} catch (Exception e) {
					throw new DAOException(e.getMessage());
				}
			}
		}
	}
	
	public static DAOFactoria getUnicaInstancia(){
		if(unicaInstancia==null){
			unicaInstancia = new JPADAOFactoria();
		}
		return unicaInstancia;
	}

	
	
	
	
}