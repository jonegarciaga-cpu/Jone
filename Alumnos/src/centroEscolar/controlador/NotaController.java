package centroEscolar.controlador;

import java.sql.SQLException;
import java.util.List;

import centroEscolar.modelo.dao.NotaDAO;
import centroEscolar.modelo.entidad.Alumno;
import centroEscolar.modelo.entidad.Nota;

/**
 * Controlador de las Notas
 */
public class NotaController {

	private NotaDAO notasdao = new NotaDAO();

	public List<Nota> getNotasAlumno(Alumno alumno) {
		try {
			return notasdao.getNotasAlumno(alumno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
