package centroEscolar.modelo.entidad;

import java.util.Objects;

/**
 * Esta entidad describe a la tabla t_persona
 */
public abstract class Persona {

	// PK
	private int id = 0;

	private String nombre = null;
	private String apellido = null;
	private String apellido2 = null;
	private String dni = null;
	private String clase = null;
	private String curso = null;

	// Relacion 1-1
	private Credencial credencial = null;

	public Persona() {
		super();
	}

	public Persona(int id, String nombre, String apellido, String apellido2, String dni, String clase, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.clase = clase;
		this.curso = curso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Credencial getCredencial() {
		return credencial;
	}

	public void setCredencial(Credencial credencial) {
		this.credencial = credencial;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, apellido2, clase, credencial, curso, dni, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(apellido2, other.apellido2)
				&& Objects.equals(clase, other.clase) && Objects.equals(credencial, other.credencial)
				&& Objects.equals(curso, other.curso) && Objects.equals(dni, other.dni) && id == other.id
				&& Objects.equals(nombre, other.nombre);
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", apellido2=" + apellido2
				+ ", dni=" + dni + ", clase=" + clase + ", curso=" + curso + ", credencial=" + credencial
				+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}
