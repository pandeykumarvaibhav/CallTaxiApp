package com.cg.calltaxiapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.calltaxiapp.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

 public Optional<Admin> findByEmail(String email);
 
 @Query("SELECT a FROM Admin a WHERE a.email = ?1 AND a.password = ?2")
 public Optional<Admin> findByEmailAndPassword(String email, String password);
}
