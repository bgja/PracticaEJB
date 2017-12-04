package controlador;

import modelo.Alineacion;
import modelo.Color;
import modelo.Partido;
import modelo.Temporada;
import modelo.Usuario;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ControladorRemoto {
	
	public Usuario registrarUsuario(String usuario, String clave, String mail, String movil);
	
	public boolean login(String usuario, String clave);	
	
	public Usuario obtenerUsuario(String usuario);

	public Usuario actualizarUsuario(String usuario, String clave, String mail, String movil);

	public List<Usuario> listarUsuarios();
	
	public Temporada registroTemporada(String nombre, String lugar, int minimo);
	
	public List<Temporada> listarTemporadas();

	public Temporada anadirUsuarioTemporada(String temporada, String usuario);
	
	public Temporada quitarUsuarioTemporada(String temporada, String usuario);

	public Temporada obtenerTemporada(String temporada);

	public Partido obtenerPartido(Long partido);

	public Partido registrarPartido(Date fecha, String temporada);

	public Partido confirmarAsistencia(Long id, String usuario);

	public Alineacion registrarAlineacion(Long idPartido, String nombre, Color color, int tanteo);
	
	public Alineacion registrarUsuariosAlineacion(String usuario, String alineacion);
	
	public List<Partido> obtenerPartidoEntreFechas(Date f1, Date f2);
	
	public List<Partido> obtenerPartidoTemporada(String temporada);


}
