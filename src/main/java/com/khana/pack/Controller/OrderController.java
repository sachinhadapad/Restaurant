package com.khana.pack.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.khana.pack.Entity.OrderFood;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("Order")
public class OrderController {

	@PostMapping("/add")
	public ResponseEntity<?> placeoneorder(@RequestBody OrderFood orderfood)
	{
		
		return ResponseEntity.status(HttpStatus.OK).body("Success!!!!!");
		
	}
}
