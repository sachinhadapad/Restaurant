package com.khana.pack.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khana.pack.Entity.OrderFood;

public interface OrderRepository extends JpaRepository<OrderFood,Long>{

}
