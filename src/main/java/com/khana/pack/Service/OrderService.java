package com.khana.pack.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khana.pack.Entity.OrderFood;
import com.khana.pack.Repository.MenuRepository;
import com.khana.pack.Repository.OrderRepository;
import com.khana.pack.Repository.UserRepository;

@Service
public class OrderService {
@Autowired 
OrderRepository orderrepo;

@Autowired
MenuRepository menurepo;

@Autowired
UserRepository userrepo;


   public void placeorder(OrderFood orderFood)
	{ Long userId = orderFood.getUser().getId();
    if (!userrepo.existsById(userId)) {
        throw new RuntimeException("User with ID " + userId + " not found.");
    }

    // Validate menu items
    orderFood.getMenuitem().forEach(item -> {
        if (!menurepo.existsById(item.getId())) {
            throw new RuntimeException("Menu item with ID " + item.getId() + " not found.");
        }
    });

    // Save the order
    orderrepo.save(orderFood);
		
	}


}
