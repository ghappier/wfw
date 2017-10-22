package com.lizq.wfw.provider.user;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	/**
	 * MockMvcResultMatchers.jsonPath的用法参考http://goessner.net/articles/JsonPath/
	 * 
	 * @throws Exception
	 */
	@Test
	public void testList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("查询成功"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data", Matchers.hasSize(2)))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data[0].id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data[0].name").value("lizq"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data[0].age").value(20))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data[1].id").value(2))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data[1].name").value("hezj"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data[1].age").value(25));
	}

	@Test
	public void testGet() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/{id}", 1).accept(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("查询成功"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("lizq"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.age").value(20));
	}

	@Test
	public void testAdd() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/").param("id", "1").param("name", "lizq").param("age", "20")
				.accept(MediaType.APPLICATION_JSON_UTF8)).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("新增成功"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("lizq"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.age").value(20));
	}

	@Test
	public void testModify() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.put("/").param("id", "1").param("name", "lizq").param("age", "20")
				.accept(MediaType.APPLICATION_JSON_UTF8)).andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("修改成功"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.name").value("lizq"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.age").value(20));
	}

	@Test
	public void testDelete() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.delete("/{id}", 1).accept(MediaType.APPLICATION_JSON_UTF8))
				.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.jsonPath("$.success").value(true))
				.andExpect(MockMvcResultMatchers.jsonPath("$.msg").value("删除成功"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.data.id").value(1));
	}

}
