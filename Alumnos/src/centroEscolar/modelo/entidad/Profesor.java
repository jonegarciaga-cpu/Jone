package centroEscolar.modelo.entidad;

/**
 * Esta entidad describe a la tabla t_profesor
 */
public class Profesor extends Persona{

	public Profesor() {
		
	}
	
	public Profesor(int id, String nombre, String apellido, String apellido2, String dni, String clase, String curso) {
		super(id, nombre, apellido, apellido2, dni, clase, curso);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Profesor [getId()=" + getId() + ", getNombre()=" + getNombre() + ", getApellido()=" + getApellido()
				+ ", getApellido2()=" + getApellido2() + ", getDni()=" + getDni() + ", getClase()=" + getClase()
				+ ", getCurso()=" + getCurso() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ "]";
	}
	
}
