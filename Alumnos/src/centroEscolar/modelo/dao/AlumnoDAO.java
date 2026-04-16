package centroEscolar.modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import centroEscolar.modelo.entidad.Alumno;
import centroEscolar.modelo.utils.DBUtils;

public class AlumnoDAO extends AbstractDAO implements DAOInterface <Alumno>{

	public Alumno getAlumno(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> getTodos() throws SQLException, Exception {
		List<Alumno> ret = null;

		String sql = "select * from t_alumno";

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
					ret = new ArrayList<Alumno> ();
				
				Alumno alumno = new Alumno(resultSet.getInt("id"), resultSet.getString("nombre"),
						resultSet.getString("apellido"), resultSet.getString("apellido2"), resultSet.getString("dni"),
						resultSet.getString("clase"), resultSet.getString("curso"));
				
				ret.add(alumno);
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
	public void insert(Alumno t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Alumno t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Alumno t) {
		// TODO Auto-generated method stub
		
	}

}
