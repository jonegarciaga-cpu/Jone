package centroEscolar.modelo.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Describe los metodos que tienen que implementar todos los DAO
 */
public interface DAOInterface <T>{

	public List<T> getTodos () throws SQLException, Exception;
	public void insert (T t);
	public void update (T t);
	public void delete (T t);
}
