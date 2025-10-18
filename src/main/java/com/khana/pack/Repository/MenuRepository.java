package com.khana.pack.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khana.pack.Entity.MenuItem;

public interface MenuRepository extends JpaRepository <MenuItem,Long>{

	Optional<MenuItem> findByNameAndCategory(String name, String category);

	List<MenuItem> findByNameContainingOrCategoryContaining(String name,String category);

}
