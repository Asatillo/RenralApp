package com.CarRental.CarRentalApplication.service;

import com.CarRental.CarRentalApplication.model.Car;
import com.CarRental.CarRentalApplication.model.Reservation;
import com.CarRental.CarRentalApplication.model.User;
import com.CarRental.CarRentalApplication.repository.CarDao;
import com.CarRental.CarRentalApplication.repository.ReservationDao;
import com.CarRental.CarRentalApplication.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    CarDao carDao;

    @Autowired
    ReservationDao reservationDao;

    @Autowired
    UserDao userDao;

    public List<Car> findAvailableCarsForPeriod(LocalDate startDate, LocalDate endDate) {
        if (startDate != null && endDate != null && endDate.isAfter(startDate)){
            return carDao.findAvailableCarsForPeriod(startDate, endDate);
        }
        return List.of(); // return empty list
    }

    public Car findCarById(Integer id) {
        return carDao.findById(id).orElse(null);
    }

    public ResponseEntity<String> makeReservation(Integer id, LocalDate startDate, LocalDate endDate, String name,
                                                  String lastName, String email, String address, String phone) {
        Car car = carDao.findById(id).orElse(null);

//        check if user exists if no create a new one
        User user = userDao.findByEmail(email);
        if (user == null){
            user = new User(name, lastName, email, address, phone);
            userDao.save(user);
        }
        if (car != null){
            try{
                Reservation reservation = new Reservation(startDate, endDate, "booked", user, car);
                reservationDao.save(reservation);

                StringBuilder message = new StringBuilder();
                message.append("Congratulations! You have successfully reserved a ");
                message.append(car.getBrand());
                message.append(" ");
                message.append(car.getModel());
                message.append(" from ");
                message.append(startDate);
                message.append(" to ");
                message.append(endDate);
                message.append(" for ");
                message.append(reservation.getTotalPrice());
                message.append(" euros.");
                return new ResponseEntity<>(message.toString(), HttpStatus.OK);
            }catch (Exception e){
                return new ResponseEntity<>("Something went wrong on our side :((", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>("Bad request!", HttpStatus.BAD_REQUEST);
    }

}
