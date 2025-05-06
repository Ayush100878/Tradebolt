package com.example.tradebolt.repository;

//to manage data in database

import com.example.tradebolt.Modal.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> { // provides crud operations for User and primary key type is Long

    User findByEmail(String email);
}
