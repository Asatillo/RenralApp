package com.CarRental.CarRentalApplication.repository;

import com.CarRental.CarRentalApplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    User findByEmail(String email);

//    Optional<User> findByUsername(String username);
//
//    Boolean existsByUsername(String username);
}
