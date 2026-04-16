package centroEscolar.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import centroEscolar.modelo.entidad.Alumno;
import centroEscolar.modelo.entidad.Nota;
import centroEscolar.modelo.utils.DBUtils;

public class NotaDAO extends AbstractDAO implements DAOInterface<Nota> {

	public List<Nota> getNotasAlumno(Alumno alumno) throws SQLException, Exception {
		List<Nota> ret = null;

		String sql = "SELECT id, asignatura, valor FROM `t_nota` where id_alumno = " + alumno.getId();

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			Class.forName(DBUtils.DRIVER);

			connection = DriverManager.getConnection(DBUtils.URL, DBUtils.USER, DBUtils.PASS);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				if (ret == null)
					ret = new ArrayList<Nota>();

				Nota nota = new Nota(resultSet.getInt("id"), resultSet.getString("asignatura"),
						resultSet.getString("valor"), alumno);
				ret.add(nota);
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

	@Override
	public List<Nota> getTodos() throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Nota t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Nota t) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Nota t) {
		// TODO Auto-generated method stub

	}

}
