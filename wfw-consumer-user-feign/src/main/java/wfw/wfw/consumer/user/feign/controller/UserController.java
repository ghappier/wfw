package wfw.wfw.consumer.user.feign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lizq.wfw.commons.json.JsonResult;
import com.lizq.wfw.commons.model.User;

import wfw.wfw.consumer.user.feign.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value="/")
	public JsonResult<List<User>> list() {
		return userService.list();
	}
	
	@GetMapping(value="/{id}")
	public JsonResult<User> get(@PathVariable int id) {
		return userService.get(id);
	}
	
	@PostMapping(value="/")
	public JsonResult<User> add(User user) {
		return userService.add(user);
	}
	
	@PutMapping(value="/")
	public JsonResult<User> modify(User user) {
		return userService.modify(user);
	}
	
	@DeleteMapping(value="/{id}")
	public JsonResult<User> delete(@PathVariable int id) {
		return userService.delete(id);
	}
}
