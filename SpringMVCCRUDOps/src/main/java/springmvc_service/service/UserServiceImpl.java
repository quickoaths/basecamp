package springmvc_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvc_DAO.dao.UserDAO;
import springmvc_model.model.User;

@Service
public class UserServiceImpl implements UserService {
	UserDAO userdao;
	
	@Autowired
	public UserDAO getUserdao() {
		return userdao;
	}

	public void setUserdao(UserDAO userdao) {
		this.userdao = userdao;
	}

	public List<User> listallUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addUser(User user) {
		userdao.createUser(user);
		
	}

	public void updateUser(User user) {
		userdao.updateUser(user);
		
	}

	public void deleteUser(int id) {
		userdao.deleteUser(id);
		
	}

	public User findUserById(int id) {
		return userdao.readUser(id);
		
	}
	
}
