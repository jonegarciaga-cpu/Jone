package centroEscolar.modelo.entidad;

import java.util.Objects;

/**
 * Esta entidad describe a la tabla t_creencial
 */
public class Credencial {

	// PK
	private int id = 0;

	private String login = null;
	private String clave = null;
	
	// Relacion 1-1
	private Persona persona = null;
	
	public Credencial() {
		super();
	}

	public Credencial(int id, String login, String clave) {
		super();
		this.id = id;
		this.login = login;
		this.clave = clave;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clave, id, login, persona);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credencial other = (Credencial) obj;
		return Objects.equals(clave, other.clave) && id == other.id && Objects.equals(login, other.login)
				&& Objects.equals(persona, other.persona);
	}

	@Override
	public String toString() {
		return "Credencial [id=" + id + ", login=" + login + ", clave=" + clave + ", persona=" + persona + "]";
	}

}
