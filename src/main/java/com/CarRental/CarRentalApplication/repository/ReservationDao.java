package com.CarRental.CarRentalApplication.repository;

import com.CarRental.CarRentalApplication.model.Car;
import com.CarRental.CarRentalApplication.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationDao extends JpaRepository<Reservation, Integer> {

    @Query(value = "SELECT * FROM reservation\n" +
            "WHERE status='booked' or status='using';", nativeQuery = true)
    List<Reservation> getAllReservations();
}
