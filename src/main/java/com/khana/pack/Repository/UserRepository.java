package com.khana.pack.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khana.pack.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

	Optional<User> findByEmail(String email);
}
