package com.lizq.wfw.provider.user;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lizq.wfw.commons.json.JsonResult;
import com.lizq.wfw.commons.model.User;

/**
 * 
 * @author hhly-pc
 *
 */
@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value="/")
	public JsonResult<List<User>> list() {
		logger.info("查询用户 {}", "*");
		List<User> list = new ArrayList<User>(2);
		User u1 = new User();
		u1.setId(1);
		u1.setName("lizq");
		u1.setAge(20);
		list.add(u1);
		User u2 = new User();
		u2.setId(2);
		u2.setName("hezj");
		u2.setAge(25);
		list.add(u2);
		return new JsonResult<List<User>>().msg("查询成功").data(list);
	}
	
	@GetMapping(value="/{id}")
	public JsonResult<User> get(@PathVariable int id) {
		logger.info("查询用户 {}", id);
		if (id == 1) {
			User u = new User();
			u.setId(1);
			u.setName("lizq");
			u.setAge(20);
			return new JsonResult<User>().msg("查询成功").data(u);
		} else if (id ==2) {
			User u = new User();
			u.setId(2);
			u.setName("hezj");
			u.setAge(25);
			return new JsonResult<User>().msg("查询成功").data(u);
		}
		return new JsonResult<User>().msg("查询成功");
	}
	
	@PostMapping(value="/")
	public JsonResult<User> add(User user) {
		logger.info("新增用户 {}", user);
		return new JsonResult<User>().msg("新增成功").data(user);
	}
	
	@PutMapping(value="/")
	public JsonResult<User> modify(User user) {
		logger.info("修改用户 {}", user);
		return new JsonResult<User>().msg("修改成功").data(user);
	}
	
	@DeleteMapping(value="/{id}")
	public JsonResult<User> delete(@PathVariable int id) {
		logger.info("删除用户 {}", id);
		User user = new User();
		user.setId(id);
		return new JsonResult<User>().msg("修改成功").data(user);
	}
}
