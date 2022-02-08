package com.learning.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.entity.Register;
import com.learning.exception.IdNotFound;
import com.learning.exception.LoginFailed;
import com.learning.exception.RecordExists;
import com.learning.service.RegisterService;

import antlr.collections.List;

@RestController
//@RequestMapping("/api")
public class UserController {
	@Autowired
	RegisterService registerService1;
@PostMapping("/register")
public ResponseEntity<?> addUser(@RequestBody Register register) throws RecordExists
{
	Register register2=registerService1.addUser(register);
	return ResponseEntity.status(201).body(register2);
		
}
@PostMapping("/authenticate")
public ResponseEntity<?> authenticate(@RequestBody Register register) throws LoginFailed
{
	String result=registerService1.authentication(register.getEmail(), register.getPassword());
	return ResponseEntity.status(200).body(result);
}
@GetMapping("/users")
public ResponseEntity<?> updateUser()
{

	Optional<java.util.List<Register>> result=registerService1.getAllUsers();
	if(result.isEmpty())
	{
		Map<String, String> map=new HashMap<>();
		map.put("message", "No records found");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(map);
		
		
		
	}
	else
		return ResponseEntity.status(200).body(result.get());
	
}
@GetMapping("/users/{id}")
public ResponseEntity<?> getUserById(@PathVariable("id") int id) throws IdNotFound
{
	Register register=registerService1.getUserById(id);
	return ResponseEntity.status(200).body(register);
	
}
@PutMapping("/users/{id}")
public ResponseEntity<?> updateUser(@PathVariable("id") int id,@RequestBody Register register) throws IdNotFound, RecordExists
{
	Register register1=registerService1.updateUser(id,register);
	return ResponseEntity.status(200).body(register1);

}
@DeleteMapping("/users/{id}")
public ResponseEntity<?> deleteUser(@PathVariable("id") int id) throws IdNotFound
{
	String register=registerService1.deleteUser(id);
	return ResponseEntity.status(200).body(register);
	
}
//{
//    
//    "email":"goutham2@gmailcom",
//    "name":"goutham2",
//    "password":"goutham2",
//    "address":"Bangalore"
//
//    
//}
}
