package com.khana.pack.Dto;

import com.khana.pack.Entity.Restaurent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MenuHotel {

	  private Long id;
	    
	    
	    private String name;
	    
	    private String description;
	    
	   
	    private double price;
	   
	    private String category; 
	    
	    private Restaurent restaurant;
}
