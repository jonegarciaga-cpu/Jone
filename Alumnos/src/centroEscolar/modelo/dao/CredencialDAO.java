package centroEscolar.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import centroEscolar.modelo.entidad.Credencial;
import centroEscolar.modelo.utils.DBUtils;

public class CredencialDAO extends AbstractDAO implements DAOInterface<Credencial> {

	

	@Override
	public List<Credencial> getTodos() throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Credencial t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Credencial t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Credencial t) {
		// TODO Auto-generated method stub

	}

	/**
	 * Retorna la credencial asociada a un login, o NULL si no lo encuentra
	 * 
	 * @param login
	 * @return la credencial o null
	 * @throws SQLException | Exception Si hay algun error
	 */
	public Credencial getCredencial(String login) throws SQLException, Exception {
		Credencial ret = null;

		String sql = "select * from t_credencial where login ='" + login + "'";

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				ret = new Credencial(resultSet.getInt("id"), resultSet.getString("login"),
						resultSet.getString("clave"));
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
