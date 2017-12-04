package modelo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

import modelo.Partido;
import modelo.Usuario;

@Entity
public class Alineacion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String nombre;
	
	private int tanteo;
	
	@Enumerated(EnumType.STRING)
	private Color color;
	
	@ManyToMany(mappedBy="alineaciones")
	private List<Usuario> usuarios;
	
	@ManyToOne
	private Partido partido;
	
	public Alineacion(){
		this.usuarios = new LinkedList<Usuario>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTanteo() {
		return tanteo;
	}

	public void setTanteo(int tanteo) {
		this.tanteo = tanteo;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
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

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
	
	
	
}
