package com.khana.pack.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khana.pack.Dto.UserDto;
import com.khana.pack.Entity.User;
import com.khana.pack.Service.UserService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
@RequestMapping("createuser")
public class UserController {
	@Autowired 
	UserService usersevice;
	@PostMapping("/user-add")
	public ResponseEntity<?> createuser(@Valid @RequestBody UserDto dtouser,BindingResult bindingresult)
	{
		Map<String ,String> map=new HashMap<>();
		if(bindingresult.hasErrors())
		{
			for(FieldError error: bindingresult.getFieldErrors())
			{
				map.put(error.getField(), error.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
		}
		usersevice.addUser(dtouser);
		return ResponseEntity.status(HttpStatus.CREATED).body("created Successfully!!!!!!");
	}

}
