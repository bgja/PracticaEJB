package modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

import modelo.Alineacion;
import modelo.Partido;

@Entity
@NamedQueries(
		{
		@NamedQuery(	
			name="findAllUsuarios",
				query="SELECT u FROM Usuario u"),
		}
)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String usuario;
	
	private String clave;
	
	private String mail;
	
	private String movil;
	
	private String imagen;
	
	private boolean admin;
	
	@ManyToMany
	@JoinTable(name="usuario2alineacion",
		joinColumns = @JoinColumn(name="id_usuario"),
		inverseJoinColumns = @JoinColumn(name="id_alineacion"))
	private List<Alineacion> alineaciones;
	
	@ManyToMany
	@JoinTable(name="usuario2partido",
			joinColumns = @JoinColumn(name="id_usuario"),
			inverseJoinColumns = @JoinColumn(name="id_partido"))
	private List<Partido> partidos;
	
	@ManyToMany
	@JoinTable(name="usuario2temporada",
			joinColumns = @JoinColumn(name="id_usuario"),
			inverseJoinColumns = @JoinColumn(name="id_temporada"))
	private List<Temporada> temporadas;
	
	public Usuario(){
		this.admin = false;
		this.alineaciones = new LinkedList<Alineacion>();
		this.partidos = new LinkedList<Partido>();
		this.temporadas = new LinkedList<Temporada>();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Alineacion> getAlineaciones() {
		return alineaciones;
	}

	public void setAlineaciones(List<Alineacion> alineaciones) {
		this.alineaciones = alineaciones;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}

	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(List<Temporada> temporadas) {
		this.temporadas = temporadas;
	}
	
	
	
	
	
}
