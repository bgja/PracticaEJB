package dao;

import java.util.Date;
import java.util.List;

import modelo.Partido;

public interface PartidoDAO {

	
	List<Partido> findPartidoByFecha(Date f1, Date f2) throws DAOException;

	List<Partido> findPartidoByFechaCRIT(Date f1, Date f2) throws DAOException;

	Partido createPartido(Date fecha, String temporada) throws DAOException;

	Partido addUsuarioPartido(Long id, String usuario) throws DAOException;

	List<Partido> findPartidoByTemporada(String temporada) throws DAOException;

	Partido findPartido(Long partido) throws DAOException;
	
	
}
