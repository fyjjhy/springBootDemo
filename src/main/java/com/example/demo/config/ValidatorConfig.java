package com.example.demo.config;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2019/4/22
 * @see com.example.demo.config <br>
 * @since V1.0<br>
 */
@Configuration
public class ValidatorConfig {

	@Bean
	public Validator validator() {
		ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
				.configure()
				.addProperty("hibernate.validator.fail_fast", "true")
				.buildValidatorFactory();
		return factory.getValidator();
	}
}
