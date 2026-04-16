package centroEscolar.controlador;

import centroEscolar.modelo.dao.CredencialDAO;
import centroEscolar.modelo.dao.ProfesorDAO;
import centroEscolar.modelo.entidad.Credencial;
import centroEscolar.modelo.entidad.Profesor;

/**
 * Controlador de las Credenciales
 */
public class CredencialController {

	/**
	 * Retorna true si el login & pass son correctos y de un profesor, false en cualquier otro caso
	 * 
	 * @param login
	 * @param clave
	 * @return true o false
	 * @throws Exception Si hay algun error
	 */
	public boolean comprobarLoginProfesor(String login, String clave) throws Exception {
		Credencial credencial = new CredencialDAO().getCredencial(login);
		if ((null != credencial.getClave()) && credencial.getClave().equals(clave)) {
			return (null != getProfesor (credencial));
		} else {
			return false;
		}
	}
	
	/**
	 * Retorna el profesor relacionado a una Credencial, o null si no la encuentra
	 * 
	 * @param credencial
	 * @return El profesor o null
	 * @throws Exception Si hay algun error
	 */
	private Profesor getProfesor (Credencial credencial) throws Exception {
		Profesor ret = null;
		ProfesorDAO profesorDAO = new ProfesorDAO ();
		ret = profesorDAO.getByCredencial(credencial);
		return ret;
	}

}
