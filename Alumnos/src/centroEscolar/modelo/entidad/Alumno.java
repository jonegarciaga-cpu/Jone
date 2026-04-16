package centroEscolar.modelo.entidad;

import java.util.List;
import java.util.Objects;

/**
 * Esta entidad describe a la tabla t_alumno
 */
public class Alumno extends Persona {

	// Relación 1-N
	private List<Nota> notas = null;

	public Alumno() {

	}

	public Alumno(int id, String nombre, String apellido, String apellido2, String dni, String clase, String curso) {
		super(id, nombre, apellido, apellido2, dni, clase, curso);
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(notas);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(notas, other.notas);
	}

	@Override
	public String toString() {
		return getNombre();
	}

}
