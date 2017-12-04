package dao;

import java.util.List;
import modelo.Usuario;

public interface UsuarioDAO {

	public Usuario createUsuario(String usuario, String clave, String mail, String movil) throws DAOException;

	// Busca un Usuario por "usuario" (clave primaria). Si no lo encuentra
	// devuelve "null"
	public Usuario findUsuarioByUsuario(String usuario) throws DAOException;
	
	public Usuario updateUsuario(String usuario, String clave, String mail, String movil) throws DAOException;
	
	public List<Usuario> findAllUsuarios() throws DAOException;
}
