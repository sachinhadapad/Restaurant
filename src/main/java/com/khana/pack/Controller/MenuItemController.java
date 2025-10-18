package com.khana.pack.Controller;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khana.pack.Dto.MenuHotel;
import com.khana.pack.Dto.MenuItemDto;
import com.khana.pack.Service.MenuItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Menu")
public class MenuItemController {
	
	@Autowired 
	MenuItemService menuservice;
	
	@PostMapping("additems")
	public ResponseEntity<?> addmenuitem(@Valid @RequestBody MenuItemDto menudto ,BindingResult bindingresult)
	{
	   	
	   if(bindingresult.hasErrors())
	   {
		   Map<String,String> error =new HashMap<>();
		   for(FieldError e: bindingresult.getFieldErrors())
		   {
			   error.put(e.getField(), e.getDefaultMessage());
			   
		   }
		 return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		   
	   }
	   
	   menuservice.addmenu(menudto);
	  return ResponseEntity.status(HttpStatus.CREATED).body("Ctreated");
	}
	
	
	@GetMapping("m-hotel/{id}")
	public ResponseEntity<?> gethotelname(@PathVariable Long id)
	{
		MenuHotel hotel= menuservice.getthehoel(id);
		return ResponseEntity.status(HttpStatus.OK).body(hotel);
	}
	
	
	@GetMapping("byname")
	public ResponseEntity<?> getMenubyname(@RequestParam String name ,@RequestParam String category)
	{
		
		return  ResponseEntity.status(HttpStatus.OK).body(menuservice.getmenues(name,category));
	}
	

}
