package com.example.demo.controller;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.User;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2019/4/22
 * @see com.example.demo.controller <br>
 * @since V1.0<br>
 */
@RestController
@RequestMapping("/users")
@Validated
public class UserController {

	@PostMapping
	public User addUser(@RequestBody User user) {
		return user;
	}

	@GetMapping("/{name:[a-zA-Z]+}")
	public User getUserByName(
			@NotNull
			@Size(min = 1, max = 20, message = "用户名格式有误")
			@PathVariable String name) {
		User user = new User();
		user.setName(name);
		return user;
	}

	@GetMapping
	public User getUserByNameParam(
			@NotNull
			@Size(min = 1, max = 20, message = "用户名格式有误!")
			@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		return user;
	}
}
