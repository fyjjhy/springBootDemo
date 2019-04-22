package com.example.demo.handler;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.entity.ResultInfo;

/**
 * <Description> <br>
 *
 * @author 付永杰<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2019/4/22
 * @see com.example.demo.handler <br>
 * @since V1.0<br>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResultInfo<?> validationErrorHandler(MethodArgumentNotValidException ex) {
		// 同样是获取BindingResult对象，然后获取其中的错误信息
		// 如果开启了fail_fast，事实上这里只会有一个消息
		// 如果没有，则可能有多个
		List<String> errorInformation = ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
				.collect(Collectors.toList());
		return new ResultInfo<>(400, errorInformation.toString(), null);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResultInfo<?> validationErrorHandler(ConstraintViolationException ex) {
		List<String> errorInformation = ex.getConstraintViolations()
				.stream()
				.map(ConstraintViolation::getMessage)
				.collect(Collectors.toList());
		return new ResultInfo<>(400, errorInformation.toString(), null);
	}
}
