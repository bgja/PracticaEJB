package controlador;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;

import org.eclipse.persistence.internal.databaseaccess.DatasourcePlatform;

import dao.AlineacionDAO;
import dao.DAOException;
import dao.DAOFactoria;
import dao.PartidoDAO;
import dao.TemporadaDAO;
import dao.UsuarioDAO;
import modelo.Alineacion;
import modelo.Color;
import modelo.Partido;
import modelo.Temporada;
import modelo.Usuario;

@Stateful (name="ControladorRemoto")
public class ControladorEJB implements ControladorRemoto {

	private Usuario actual;
	@Resource
	private SessionContext contexto;
	
	public ControladorEJB(){
		
	}

	@PostConstruct
	public void configurarDAO(){
		try {
			DAOFactoria.setDAOFActoria(DAOFactoria.JPA);
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
	
	public Usuario registrarUsuario(String usuario, String clave, String mail, String movil){
		try{
			UsuarioDAO usuDAO = DAOFactoria.getUnicaInstancia().getUsuarioDAO();
			return usuDAO.createUsuario(usuario, clave, mail, movil);
		} catch(DAOException e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public boolean login(String usuario, String clave){
		Usuario user = obtenerUsuario(usuario);
		actual = user;
		return user.getClave().equals(clave);
	}
	
	public Usuario obtenerUsuario(String usuario){
		try{
			UsuarioDAO usuDAO = DAOFactoria.getUnicaInstancia().getUsuarioDAO();
			Usuario user = usuDAO.findUsuarioByUsuario(usuario);
			return user;
		} catch(DAOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Usuario actualizarUsuario(String usuario, String clave, String mail, String movil){
		UsuarioDAO usuDAO = DAOFactoria.getUnicaInstancia().getUsuarioDAO();
		try {
			return usuDAO.updateUsuario(usuario, clave, mail, movil);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Usuario> listarUsuarios(){
		UsuarioDAO usuDAO = DAOFactoria.getUnicaInstancia().getUsuarioDAO();
		try{
			return usuDAO.findAllUsuarios();
		}catch(DAOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Temporada registroTemporada(String nombre, String lugar, int minimo){
		TemporadaDAO tempDAO = DAOFactoria.getUnicaInstancia().getTemporadaDAO();
		try {
			return tempDAO.createTemporada(nombre, lugar, minimo);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Temporada> listarTemporadas(){
		TemporadaDAO tempDAO = DAOFactoria.getUnicaInstancia().getTemporadaDAO();
		try{
			return tempDAO.findAllTemporadas();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Temporada anadirUsuarioTemporada(String temporada, String usuario){
		TemporadaDAO tempDAO = DAOFactoria.getUnicaInstancia().getTemporadaDAO();
		try {
			return tempDAO.addUsuarioTemporada(temporada, usuario);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Temporada quitarUsuarioTemporada(String temporada, String usuario){
		TemporadaDAO tempDAO = DAOFactoria.getUnicaInstancia().getTemporadaDAO();
		try {
			return tempDAO.deleteUsuarioTemporada(temporada, usuario);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Temporada obtenerTemporada(String temporada){
		try{
			TemporadaDAO tempDAO = DAOFactoria.getUnicaInstancia().getTemporadaDAO();
			return tempDAO.findTemporada(temporada);
		} catch(DAOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Partido obtenerPartido(Long partido){
		try{
			PartidoDAO partDao = DAOFactoria.getUnicaInstancia().getPartidoDAO();
			return partDao.findPartido(partido);
		} catch(DAOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public Partido registrarPartido(Date fecha, String temporada){
		PartidoDAO parDAO = DAOFactoria.getUnicaInstancia().getPartidoDAO();
		try {
			return parDAO.createPartido(fecha, temporada);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Partido confirmarAsistencia(Long id, String usuario){
		PartidoDAO parDAO = DAOFactoria.getUnicaInstancia().getPartidoDAO();
		try {
			return parDAO.addUsuarioPartido(id, usuario);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Alineacion registrarAlineacion(Long idPartido, String nombre, Color color, int tanteo){
		AlineacionDAO aliDAO = DAOFactoria.getUnicaInstancia().getAlineacionDAO();
		try {
			return aliDAO.createAlineacion(nombre, color, tanteo, idPartido);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Alineacion registrarUsuariosAlineacion(String usuario, String alineacion){
		AlineacionDAO aliDAO = DAOFactoria.getUnicaInstancia().getAlineacionDAO();
		try {
			return aliDAO.addUsuario(alineacion, usuario);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<Partido> obtenerPartidoEntreFechas(Date f1, Date f2){
		PartidoDAO parDAO = DAOFactoria.getUnicaInstancia().getPartidoDAO();
		try {
			return parDAO.findPartidoByFecha(f1, f2);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Partido> obtenerPartidoTemporada(String temporada){
		PartidoDAO parDAO = DAOFactoria.getUnicaInstancia().getPartidoDAO();
		try {
			return parDAO.findPartidoByTemporada(temporada);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
