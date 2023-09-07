package com.CarRental.CarRentalApplication.service;

import com.CarRental.CarRentalApplication.model.Car;
import com.CarRental.CarRentalApplication.model.Reservation;
import com.CarRental.CarRentalApplication.repository.CarDao;
import com.CarRental.CarRentalApplication.repository.ReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    CarDao carDao;

    @Autowired
    ReservationDao reservationDao;

    public void addCar(){

    }

    public void removeCar(){

    }

    public void updateCar(){

    }

    public void removeReservation(){

    }

    public void addReservation(){

    }

    public void updateReservation(){

    }

    public void deactivateCar(Integer id){
        Car car = carDao.findById(id).orElse(null);
        car.setActive(false);
    }

    public List<Reservation> getAllReservations() {
        return reservationDao.getAllReservations();
    }

    public List<Car> getAllCars() {
        return carDao.findAll();
    }

    public Car getCarById(Integer id) {
        return carDao.findById(id).orElse(null);
    }
}
