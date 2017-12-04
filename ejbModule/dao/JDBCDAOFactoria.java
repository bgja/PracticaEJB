package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCDAOFactoria extends DAOFactoria {

	private DataSource ds;
	
	public JDBCDAOFactoria() {
		this.ds = null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/" + "jdbc/aadd");
			//ds = (DataSource) ctx.lookup("jdbc/aadd");

		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new JDBCUsuarioDAO(ds);
	}

}
