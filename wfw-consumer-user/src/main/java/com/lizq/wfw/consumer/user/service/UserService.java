package com.lizq.wfw.consumer.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lizq.wfw.commons.json.JsonResult;
import com.lizq.wfw.commons.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private RestTemplate template;
	
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod="listFallback")
	public JsonResult<List<User>> list() {
		return template.getForObject("http://user-service", JsonResult.class);
	}
	protected JsonResult<List<User>> listFallback() {
		return new JsonResult<List<User>>().fail().msg("加载失败");
	}
	
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod="getFallback")
	public JsonResult<User> get(int id) {
		return template.getForObject("http://user-service/{id}", JsonResult.class, id);
	}
	protected JsonResult<User> getFallback(int id) {
		return new JsonResult<User>().fail().msg("加载失败");
	}
	
	@SuppressWarnings("unchecked")
	@HystrixCommand(fallbackMethod="addFallback")
	public JsonResult<User> add(User user) {
		return template.postForObject("http://user-service", user, JsonResult.class);
	}
	protected JsonResult<User> addFallback(User user) {
		return new JsonResult<User>().fail().msg("保存失败");
	}
	
	@HystrixCommand(fallbackMethod="modifyFallback")
	public JsonResult<User> modify(User user) {
		try {
			template.put("http://user-service", user);
			return new JsonResult<User>().data(user);
		} catch (Exception e) {
			logger.error("修改用户信息出错：{}", e.getLocalizedMessage());
			return new JsonResult<User>().fail().msg(e.getLocalizedMessage()).data(user);
		}
	}
	protected JsonResult<User> modifyFallback(User user) {
		return new JsonResult<User>().fail().msg("保存失败");
	}
	
	@HystrixCommand(fallbackMethod="deleteFallback")
	public JsonResult<User> delete(int id) {
		try {
			template.delete("http://user-service/{id}", id);
			return new JsonResult<User>();
		} catch (Exception e) {
			logger.error("删除用户出错：{}", e.getLocalizedMessage());
			return new JsonResult<User>().fail().msg(e.getLocalizedMessage());
		}
	}
	protected JsonResult<User> deleteFallback(int id) {
		return new JsonResult<User>().fail().msg("删除失败");
	}
}
