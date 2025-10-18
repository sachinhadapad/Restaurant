package com.khana.pack.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khana.pack.Dto.MenuHotel;
import com.khana.pack.Dto.MenuItemDto;
import com.khana.pack.Entity.MenuItem;
import com.khana.pack.Entity.Restaurent;
import com.khana.pack.Exceptions.NameNotFoundException;
import com.khana.pack.Repository.MenuRepository;
import com.khana.pack.Repository.RestaurentRepository;

@Service
public class MenuItemService {

	@Autowired 
	MenuRepository munurepo;
	
	@Autowired 
	RestaurentRepository resto;
	
	public void addmenu(MenuItemDto menudto)
	{
		Optional<Restaurent> is=resto.findById(menudto.getRestaurantId());
		if(is.isPresent())
		{
			Restaurent re=is.get();
		MenuItem menuentity = MenuItem.builder()
				                     .name(menudto.getName())
				                     .price(menudto.getPrice())
				                     .category(menudto.getCategory())
				                     .description(menudto.getDescription())
				                     .restaurant(re)
				                     .build();
		munurepo.save(menuentity);
		}
		else
		{
			throw new NameNotFoundException(" shared id Resto is not prasent ");
		}
	}
	
	

	public MenuHotel getthehoel(Long id) {
		// TODO Auto-generated method stub
		Optional<MenuItem> data=munurepo.findById(id);
		if(data.isPresent())
		{
			MenuItem dat=data.get();
			Restaurent idof=dat.getRestaurant();
			
			MenuHotel ans=   MenuHotel.builder()
									.id(dat.getId())
									.name(dat.getName())
									.price(dat.getPrice())
									.category(dat.getCategory())
									.restaurant(idof)
									.description(dat.getDescription())
									.build();
			return ans;
		}
		else
		{
			throw new NameNotFoundException(" shared id Hotel is not prasent ");
			
		}
		
		
	}



	public List<MenuHotel> getmenues(String name, String category) {
		// TODO Auto-generated method stub
		List<MenuItem> data=munurepo.findByNameContainingOrCategoryContaining(name,category);
		if(data.isEmpty())
		{

			throw new NameNotFoundException(String.format("shared '%s','%s'  Hotel is not prasent",name,category));
		}
		List<MenuHotel> data1=new ArrayList<>();
			for(MenuItem dat: data) {
				Restaurent idof=dat.getRestaurant();
				MenuHotel ans= MenuHotel.builder()
						.id(dat.getId())
						.name(dat.getName())
						.price(dat.getPrice())
						.category(dat.getCategory())
						.restaurant(idof)
						.description(dat.getDescription())
						.build();
				data1.add(ans);
                     
			}
			
		
		return data1;
	
		
	}
	
	
	
}
