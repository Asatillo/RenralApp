package com.CarRental.CarRentalApplication.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Transient;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate startDate;
    private LocalDate endDate;

    // status: reservation, using, booked, rejected, canceled, returned
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Transient
    private Integer numberOfDays;

    @Transient
    private Double totalPrice;

    public Reservation() {}

    public Reservation(LocalDate startDate, LocalDate endDate, String status, User user, Car car) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.user = user;
        this.car = car;
        this.numberOfDays = this.getNumberOfDays();
        this.totalPrice = this.getTotalPrice();
    }
    public Integer getNumberOfDays() {
        return this.endDate.getDayOfYear() - this.startDate.getDayOfYear();
    }

    public Double getTotalPrice() {
        return this.getNumberOfDays() * this.car.getPricePerDay();
    }


}
