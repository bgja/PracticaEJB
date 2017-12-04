package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import modelo.Usuario;


public class JDBCUsuarioDAO implements UsuarioDAO {

	private DataSource ds;
	
	public JDBCUsuarioDAO(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public Usuario createUsuario(String usuario, String clave, String mail, String telefono) throws DAOException {
		Connection con;
		try {
			con = this.ds.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario WHERE usuario = ?");
			ps.setString(1, usuario);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return null;
			}
			
			ps = con.prepareStatement("INSERT INTO usuario (usuario, contrasena, mail, telefono) VALUES (?, ?, ?, ?);");
			ps.setString(1, usuario);
			ps.setString(2, clave);
			ps.setString(3, mail);
			ps.setString(4, telefono);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Usuario user = new Usuario();
		user.setUsuario(usuario);
		user.setMovil(telefono);
		user.setMail(mail);
		user.setClave(clave);
		
		return user;
	}

	@Override
	public Usuario findUsuarioByUsuario(String usuario) throws DAOException {
		Connection con;
		try{
			con = this.ds.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM usuario WHERE usuario = ?");
			ps.setString(1, usuario);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Usuario user = new Usuario();
				user.setUsuario(rs.getString("usuario"));
				user.setMovil(rs.getString("telefono"));
				user.setMail(rs.getString("mail"));
				user.setClave(rs.getString("contrasena"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Usuario updateUsuario(String usuario, String clave, String mail, String movil) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAllUsuarios() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
