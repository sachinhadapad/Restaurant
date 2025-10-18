package com.khana.pack.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khana.pack.Dto.RestaurentDto;
import com.khana.pack.Service.RestaurentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Restaurents")
public class RestaurentController {
	
	@Autowired
	RestaurentService restaurentservice;
	
	@PostMapping("/add")
	public ResponseEntity<?> addcontroll(@Valid @RequestBody RestaurentDto restaurentdto, BindingResult bindingresult)
	{
		if(bindingresult.hasErrors())
		{
			Map<String,String> error=new HashMap<>();
			for(FieldError er: bindingresult.getFieldErrors())
			{
				error.put(er.getField(), er.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		restaurentservice.addRestaurent(restaurentdto);
		return ResponseEntity.status(HttpStatus.OK).body("added new restaurent");
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updatecntroll(@Valid  @RequestBody RestaurentDto restaurentdto, BindingResult bindingresult)
	{
		if(bindingresult.hasErrors())
		{
			Map<String,String> error=new HashMap<>();
			for(FieldError er: bindingresult.getFieldErrors())
			{
				error.put(er.getField(), er.getDefaultMessage());
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		}
		restaurentservice.updateRestorent(restaurentdto);
		
		return ResponseEntity.status(HttpStatus.OK).body("Updeted new restaurent"+restaurentdto.getName());
		
	}
	
	
	@GetMapping("/getall")
	public ResponseEntity<List<RestaurentDto>> getall()
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(restaurentservice.getAllResto());
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteresto(@PathVariable Long id)
	{
		restaurentservice.deleteResto(id);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted  "+id );
	}
	
	
	
	
	

}
