package com.CarRental.CarRentalApplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean active;

    @NotBlank(message = "Brand is mandatory")
    private String brand;

    @NotBlank(message = "Model is mandatory")
    private String model;
    private Double pricePerDay;
    private Integer seats;
    private String fuelType;
    private String quality;
    private boolean childSeat;
    private boolean additionalDriver;
    private boolean navigationSystem;
    private boolean fullInsurance;
    private boolean theftProtection;

    public Car() {}
}
