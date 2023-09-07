package com.CarRental.CarRentalApplication.model;

import jakarta.persistence.*;
import lombok.Data;



@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String address;
    private String phoneNumber;
    private String name;
    private String lastName;

    public User() {}

    public User(String email, String address, String phoneNumber, String name, String lastName) {
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.lastName = lastName;
    }
}
