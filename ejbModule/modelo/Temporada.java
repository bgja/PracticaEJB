package modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
@NamedQueries(
		{
		@NamedQuery(	
			name="findAllTemporadas",
				query="SELECT t FROM Temporada t"),
		}
)
public class Temporada implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;
	
	private String lugar;
	
	private int minimo;
	
	@ManyToMany(mappedBy="temporadas")
	private List<Usuario> usuarios;
	
	@OneToMany(mappedBy="temporada")
	private List<Partido> partidos;
	
	public Temporada(){
		this.usuarios = new LinkedList<Usuario>();
		this.partidos = new LinkedList<Partido>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}
	
	
	
	
	
}
