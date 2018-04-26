package com.ngboot.CURD_example_ng_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ngboot.CURD_example_ng_boot.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);
}
