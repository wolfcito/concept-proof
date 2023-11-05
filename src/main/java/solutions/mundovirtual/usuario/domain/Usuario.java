package solutions.mundovirtual.usuario.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	@Id
	private Integer id;
	private String nombre;
	private String clave;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
}
