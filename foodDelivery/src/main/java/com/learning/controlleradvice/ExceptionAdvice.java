package com.learning.controlleradvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionAdvice {
@ExceptionHandler(Exception.class)
public ResponseEntity<?> exceptionHandler(Exception e)
{
	Map<String,String> hashMap=new HashMap<>();
	hashMap.put("message",e.getMessage());
	return ResponseEntity.badRequest().body(hashMap);
}

}
