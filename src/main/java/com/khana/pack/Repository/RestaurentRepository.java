package com.khana.pack.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khana.pack.Entity.Restaurent;

public interface RestaurentRepository extends JpaRepository<Restaurent,Long>{

	Optional<Restaurent> findByName(String name);

	
}
