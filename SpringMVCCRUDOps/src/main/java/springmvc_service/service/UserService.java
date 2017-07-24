package springmvc_service.service;

import java.util.List;

import springmvc_model.model.User;

public interface UserService {
	public List<User> listallUsers();
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public User findUserById(int id);
}
