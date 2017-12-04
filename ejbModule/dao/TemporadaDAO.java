package dao;

import java.util.List;
import modelo.Temporada;

public interface TemporadaDAO {
	
	public Temporada createTemporada(String nombre, String lugar, int minimo) throws DAOException;
	
	public Temporada findTemporada(String nombre) throws DAOException;

	public Temporada addUsuarioTemporada(String temporada, String usuario) throws DAOException;

	public Temporada deleteUsuarioTemporada(String temporada, String usuario) throws DAOException;

	public List<Temporada> findAllTemporadas() throws DAOException;

}
