package czy.taotao.shop.controller;

import java.util.List;
import java.util.ArrayList;
import czy.taotao.shop.model.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import czy.taotao.shop.service.UserService;
import czy.taotao.shop.exception.HttpException;

@RestController("UserController")
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> findUsers() {
		return this.userService.findUsers();
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User findUserById(@PathVariable int id) {
		return this.userService.findUserById(id);
	}

	@RequestMapping(value = "/user/insert", method = RequestMethod.POST)
	public void insertUser(@RequestBody User user) throws HttpException{
		this.userService.insertUser(user);
		return;
	}
	
	@RequestMapping(value = "/user/update", method = RequestMethod.POST)
	public void updateUser(@RequestBody User user) {
		this.userService.updateUser(user);
		return;
	}

	
	@RequestMapping(value = "/user/delete",method = RequestMethod.POST)
	public void deleteUser(@RequestBody User user) {
		this.userService.deleteUser(user.getId());
		return;
	}
}