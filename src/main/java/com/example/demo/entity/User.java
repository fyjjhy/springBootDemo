package com.example.demo.entity;

import javax.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2019/4/22
 * @see com.example.demo.entity <br>
 * @since V1.0<br>
 */
@Getter
@Setter
public class User {

	@NotBlank(message = "用户名不能为空")
	private String name;

	@Max(value = 120, message = "年龄不能超过120岁")
	private int age;

	@NotNull
	@Size(min = 8, max = 20, message = "密码必须大于8位并且小于20位")
	private String password;

	@Email(message = "请输入符合格式的邮箱")
	private String email;
}
