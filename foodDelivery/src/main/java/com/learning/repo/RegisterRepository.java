package com.learning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.entity.Register;
@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {
	Boolean existsByEmail(String email);
	//Login
	Boolean existsByEmailAndPassword(String email,String password);
}
