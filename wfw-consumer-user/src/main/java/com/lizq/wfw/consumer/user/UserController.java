package com.lizq.wfw.consumer.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
	
	@Autowired
	private RestTemplate template;
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/")
	public JsonResult<List<User>> list() {
		return template.getForObject("http://user-service", JsonResult.class);
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping(value="/{id}")
	public JsonResult<User> get(@PathVariable int id) {
		logger.info("===================== id = {}", id);
		return template.getForObject("http://user-service/{id}", JsonResult.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping(value="/")
	public JsonResult<User> add(User user) {
		return template.postForObject("http://user-service", user, JsonResult.class);
	}
	
	@PutMapping(value="/")
	public JsonResult<User> modify(User user) {
		try {
			template.put("http://user-service", user);
			return new JsonResult<User>().data(user);
		} catch (Exception e) {
			logger.error("修改用户信息出错：{}", e.getLocalizedMessage());
			return new JsonResult<User>().fail().msg(e.getLocalizedMessage()).data(user);
		}
	}
	
	@DeleteMapping(value="/{id}")
	public JsonResult<User> delete(@PathVariable int id) {
		try {
			template.delete("http://user-service/{id}", id);
			return new JsonResult<User>();
		} catch (Exception e) {
			logger.error("删除用户出错：{}", e.getLocalizedMessage());
			return new JsonResult<User>().fail().msg(e.getLocalizedMessage());
		}
	}
}
