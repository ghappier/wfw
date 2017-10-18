package wfw.wfw.consumer.user.feign.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lizq.wfw.commons.json.JsonResult;
import com.lizq.wfw.commons.model.User;

@FeignClient(name="user-service", fallback=UserServiceFallback.class)
public interface UserService {

	@GetMapping(value="/")
	JsonResult<List<User>> list();
	
	@GetMapping(value="/{id}")
	JsonResult<User> get(@PathVariable("id") int id);
	
	@PostMapping(value="/")
	JsonResult<User> add(User user);
	
	@PutMapping(value="/")
	JsonResult<User> modify(User user);
	
	@DeleteMapping(value="/{id}")
	JsonResult<User> delete(@PathVariable("id") int id);
}
