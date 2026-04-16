package centroEscolar.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import centroEscolar.modelo.entidad.Credencial;
import centroEscolar.modelo.entidad.Profesor;
import centroEscolar.modelo.utils.DBUtils;

public class ProfesorDAO extends AbstractDAO implements DAOInterface<Profesor> {

	

	@Override
	public List<Profesor> getTodos() throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Profesor t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Profesor t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Profesor t) {
		// TODO Auto-generated method stub

	}

	/**
	 * Retorna el profesor asociado a una credencial, o NULL si no la encuentra
	 * 
	 * @param credencial
	 * @return el Profesor o null
	 * @throws SQLException | Exception Si hay algun error
	 */	public Profesor getByCredencial(Credencial credencial) throws Exception {
		Profesor ret = null;

		String sql = "select * from t_profesor where fk_cred = '" + credencial.getId() + "'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				ret = new Profesor(resultSet.getInt("id"), resultSet.getString("nombre"),
						resultSet.getString("apellido"), resultSet.getString("apellido2"), resultSet.getString("dni"),
						resultSet.getString("clase"), resultSet.getString("curso"));
			}

		} catch (SQLException sqle) {
			throw sqle;
		} catch (Exception e) {
			throw e;
		} finally {
			// Cerramos al reves de como las abrimos
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
				// No hace falta
			}
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
				// No hace falta
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// No hace falta
			}
		}
		return ret;
	}

}
