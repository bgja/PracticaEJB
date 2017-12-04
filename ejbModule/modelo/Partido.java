package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

import modelo.Alineacion;
import modelo.Usuario;

@Entity
public class Partido implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@OneToMany(mappedBy="partido")
	private List<Alineacion> alineaciones;
	
	@ManyToMany(mappedBy="partidos")
	private List<Usuario> asistentes;
	
	@ManyToOne
	private Temporada temporada;
	
	public Partido(){
		this.alineaciones = new LinkedList<Alineacion>();
		this.asistentes = new LinkedList<Usuario>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
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

	public List<Usuario> getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(List<Usuario> asistentes) {
		this.asistentes = asistentes;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}
}
