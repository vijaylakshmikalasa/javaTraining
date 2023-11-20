package com.valtech.training.firstspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.firstspringboot.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>  {

	User findByUsername(String username);

}
