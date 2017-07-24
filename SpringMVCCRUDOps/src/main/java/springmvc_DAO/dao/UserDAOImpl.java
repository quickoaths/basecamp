package springmvc_DAO.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import springmvc_model.model.User;
//Annotation - stereotype for persistence layer
@Repository 
public class UserDAOImpl implements UserDAO{
	
	//Use of named parameters rather than traditional '?' place holders.
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
    //Fields are injected right after construction of a bean
	@Autowired
	public void setnamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) throws DataAccessException{
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	public List<User> listAll() {
		String sql = "select ID, USERNAME, PASSWORD from USERS;";
		List<User> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new UserMapper());
		return list;
	}
	
	private SqlParameterSource getSqlParameterByModel(User u) {
		MapSqlParameterSource user_values = new MapSqlParameterSource();
		if(u != null) {
			user_values.addValue("ID", u.getId());
			user_values.addValue("USERNAME", u.getUname());
			user_values.addValue("PASSWORD", u.getPword());
		}
		return user_values;
	}
	
	private static final class UserMapper implements RowMapper<User>{
		public User mapRow(ResultSet rs, int rowNum) throws SQLException{
			User u = new User();
			u.setId(rs.getInt("ID"));
			u.setUname(rs.getString("USERNAME"));
			u.setPword(rs.getString("PASSWORD"));
			return u;
		}
	}

	public void createUser(User u) {
		String sql = "INSERT INTO USERS (ID, USERNAME, PASSWORD) VALUES (:ID, :USERNAME, :PASSWORD)";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(u));
	}

	public void deleteUser(int id) {
		String sql = "DELETE FROM USER WHERE ID = :ID";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(new User(id)));
		
	}
	
	public void updateUser(User u) {
		String sql = "UPDATE USERS SET USERNAME = :USERNAME, PASSWORD = :PASSWORD WHERE ID = :ID";
		namedParameterJdbcTemplate.update(sql, getSqlParameterByModel(u));
		
	}

	public User readUser(int id) {
		String sql = "SELECT * FROM USERS WHERE ID = :ID";
		return namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new User(id)), new UserMapper());
	}

}
