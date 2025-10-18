package com.khana.pack.Dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder

@Data
@NoArgsConstructor
@AllArgsConstructor

public class RestaurentDto {
	    
	    private Long id;
	    @NotNull(message=" Name should not be null")
	    @Size(min=2,max=20,message="name between 2 to 20 letters")
	    private String name;    
	    
	    @NotNull(message=" Location should not be null")
	    @Size(min=2,max=20,message="name between 2 to 20 letters")
	    private String location;
	    
	    
	    @NotNull(message="Description should not  be null")
	    @Size(min=10,max=100,message="name between 2 to 100 letters")
	    private String description;
	    
	    
	    @NotNull(message=" Contact number should not be null")
	    @Size(min=3,max=15,message="Number should be 10 letters")
	    private String contact;
	    
	    private double rating;
	    
	   
	   

}


