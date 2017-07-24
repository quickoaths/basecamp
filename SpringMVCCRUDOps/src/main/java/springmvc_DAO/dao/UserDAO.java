package springmvc_DAO.dao;

import java.util.List;

import springmvc_model.model.User;

//(DAO) is an object that provides an abstract 
//interface to some type of database or other 
//persistence mechanism
public interface UserDAO {
	public List<User> listAll();
	
	//Create operations
	public void createUser(User u);
	
	//Delete operations
	public void deleteUser(int enable_id);
	
	//Read operations
	public User readUser(int enable_id);
	
	//Update Operations
	public void updateUser(User u);
	
}
