package com.khana.pack.Dto;
import com.khana.pack.Entity.Restaurent;

import jakarta.validation.constraints.NotBlank;
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

public class MenuItemDto {

    private Long id;
    
    @NotBlank(message="name should not be null")
    @Size(min=3,message="Altlest 3 characters need ")
    private String name;
    
    private String description;
    
    @NotNull(message="Price cannot be  null")
    private double price;
    
    @NotBlank(message="Category should not be null")
    private String category; 
    
    @NotNull(message="For which hotel are u adding thise!!!!!!!!!!!")
    private Long restaurantId;
    
}




