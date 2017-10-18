package wfw.wfw.consumer.user.feign.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.lizq.wfw.commons.json.JsonResult;
import com.lizq.wfw.commons.model.User;

public class UserServiceFallback implements UserService {

	@Override
	public JsonResult<List<User>> list() {
		return new JsonResult<List<User>>().fail().msg("加载失败");
	}

	@Override
	public JsonResult<User> get(@PathVariable("id") int id) {
		return new JsonResult<User>().fail().msg("加载失败");
	}

	@Override
	public JsonResult<User> add(User user) {
		return new JsonResult<User>().fail().msg("保存失败");
	}

	@Override
	public JsonResult<User> modify(User user) {
		return new JsonResult<User>().fail().msg("保存失败");
	}

	@Override
	public JsonResult<User> delete(@PathVariable("id") int id) {
		return new JsonResult<User>().fail().msg("删除失败");
	}

}
