package com.CarRental.CarRentalApplication.repository;

import com.CarRental.CarRentalApplication.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDao extends JpaRepository<Role, Integer> {
//    Optional<Role> findByName(Integer integer);
}
