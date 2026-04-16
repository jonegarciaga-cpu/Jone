package centroEscolar.modelo.entidad;

import java.util.Objects;

/**
 * Esta entidad describe a la tabla t_nota
 */
public class Nota {

	// PK
	private int id = 0;

	private String asignatura = null;
	private String valor = null;

	// Relación N-1
	private Alumno alumno = null;

	public Nota(String asignatura, String valor) {
		super();
		this.asignatura = asignatura;
		this.valor = valor;
	}

	public Nota(int id, String asignatura, String valor, Alumno alumno) {
		super();
		this.id = id;
		this.asignatura = asignatura;
		this.valor = valor;
		this.alumno = alumno;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(alumno, asignatura, id, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(alumno, other.alumno) && Objects.equals(asignatura, other.asignatura) && id == other.id
				&& Objects.equals(valor, other.valor);
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", asignatura=" + asignatura + ", valor=" + valor + ", alumno=" + alumno + "]";
	}

}
