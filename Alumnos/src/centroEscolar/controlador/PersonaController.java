package centroEscolar.controlador;

import java.sql.SQLException;
import java.util.List;

import centroEscolar.modelo.dao.AlumnoDAO;
import centroEscolar.modelo.entidad.Alumno;

/**
 * Controlador de las Personas (Alumnos y Profesores)
 */
public class PersonaController {

	/**
	 * Retornar todos los alumnos, o null si no hay
	 * 
	 * @return los alumnos o null
	 */
	public List<Alumno> getTodos() {
		try {
			return (new AlumnoDAO()).getTodos();
		} catch (SQLException e) {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
