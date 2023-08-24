package com.example.hotel_reservation_management.repository;

import com.example.hotel_reservation_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {
}
