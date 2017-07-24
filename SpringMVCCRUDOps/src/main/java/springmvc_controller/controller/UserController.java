package springmvc_controller.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springmvc_model.model.User;
import springmvc_service.service.UserService;

// http://stacktips.com/tutorials/java/spring/how-spring-controller-request-mapping-works-in-spring-mvc

// Types of request mapping:
/*
 * Handler level mapping | Mapping at Controller class level | Mapping requests by request type
 * Dispatcher Servlet is used to handle all incoming requests and route 
 * them through Spring. When DispatcherServlet receives a web request, 
 * it determines which controllers should handle the incoming request.
 * */

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView model = new ModelAndView("user/user_page");
		List<User> list = userservice.listallUsers();
		model.addObject("listUser", list);
		return null;
		
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("user/user_form");
		User user = new User();
		model.addObject("userForm", user);
		return null;
		
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public ModelAndView update(@PathVariable("id") int id) {
		ModelAndView model = new ModelAndView("user/user_page");
		User user = userservice.findUserById(id);
		model.addObject("listUser", user);
		return null;
		
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("userForm") User user) {
		if(user != null && user.getId() != 0) { //putting second null as zero
			//update
			userservice.updateUser(user);
		} else {
			userservice.addUser(user);
		}
		return new ModelAndView("redirect/list");
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id) {
		userservice.deleteUser(id);
		return new ModelAndView("redirect/list");	
	}
	
}
