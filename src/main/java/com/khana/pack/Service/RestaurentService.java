package com.khana.pack.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khana.pack.Dto.RestaurentDto;
import com.khana.pack.Entity.Restaurent;
import com.khana.pack.Exceptions.InvalidMobileNumberException;
import com.khana.pack.Exceptions.NameNotFoundException;
import com.khana.pack.Repository.RestaurentRepository;

@Service
public class RestaurentService {

	@Autowired 
	RestaurentRepository restaurentrepository;
	// Adding New Restorent
	public void addRestaurent(RestaurentDto restaurentdto)
	{
		 String number=restaurentdto.getContact();
		 for(char c: number.toCharArray())
		 {
			 if(Character.isLetter(c))
			 {
				 throw new InvalidMobileNumberException(String.format("This %s add correct mobile number",c));
			 }
		 }
		Restaurent retaurent=Restaurent.builder()
				                        .name(restaurentdto.getName())
				                        .location(restaurentdto.getLocation())
				                        .description(restaurentdto.getDescription())
		                                .rating(restaurentdto.getRating())
		                                .contact(restaurentdto.getContact())
		                                .build();
		//throw new NameNotFoundException("kaisa laga masak");
		
		
		 restaurentrepository.save(retaurent);
		 
		
	}
	
	public void updateRestorent(RestaurentDto restaurentdto)
	{
		Optional<Restaurent> conten=restaurentrepository.findByName(restaurentdto.getName());
		if(conten.isEmpty())
		{
			throw new NameNotFoundException("This named Restaurent is Not Prasent ");
		}
		else
		{
			Restaurent update=conten.get();
			update.setLocation(restaurentdto.getLocation());
	        update.setDescription(restaurentdto.getDescription());
	        update.setContact(restaurentdto.getContact());
	        update.setRating(restaurentdto.getRating());
	        restaurentrepository.save(update);
		}
		
		
	}
	
	public List<RestaurentDto> getAllResto()
	{
		List<Restaurent> allRestaurent=restaurentrepository.findAll();
		List<RestaurentDto> dtoresto=allRestaurent.stream()
				                                  .map(one ->  RestaurentDto.builder()
				                                		  							.id(one.getId())
				                                			                        .name(one.getName())
				                                			                        .contact(one.getContact())
				                                			                        .description(one.getDescription())
				                                			                        .rating(one.getRating())
				                                			                        .build())
				                                	  
				                                	  
				                                
				                                  .collect(Collectors.toList());
	
		return dtoresto;
		
	}

	public void deleteResto(Long id)
	{
		Optional<Restaurent> isthere=restaurentrepository.findById(id);
		if(isthere.isPresent())
		{
			restaurentrepository.deleteById(id);
		}
		else
		{
			throw new NameNotFoundException(String.format("This %s is not in the data base",id));
		}
		
	}
	
	
}
