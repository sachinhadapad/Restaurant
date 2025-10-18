package com.khana.pack.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khana.pack.Dto.UserDto;
import com.khana.pack.Entity.User;
import com.khana.pack.Exceptions.NameNotFoundException;
import com.khana.pack.Repository.UserRepository;

import jakarta.validation.Valid;

@Service
public class UserService {

	@Autowired 
	UserRepository userrepo;
	
	public void addUser(@Valid UserDto dtouser)
	{
	Optional<User> isthere=	userrepo.findByEmail(dtouser.getEmail());
	if(isthere.isPresent())
	{
		 throw new NameNotFoundException(String.format("Email %s is alredy exist!",dtouser.getEmail()));
	}
	else
		
	{
		User ob=User.builder()
				       .adress(dtouser.getAddress())
				       .email(dtouser.getEmail())
				       .name(dtouser.getName())
				       .phone(dtouser.getPhone())
				       .build();
		 userrepo.save(ob);
	}
	
	}
}
