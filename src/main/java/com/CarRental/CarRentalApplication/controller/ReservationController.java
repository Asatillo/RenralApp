package com.CarRental.CarRentalApplication.controller;

import com.CarRental.CarRentalApplication.model.Car;
import com.CarRental.CarRentalApplication.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("")
    public String searchCar(Model model){
        model.addAttribute("title", "Car Rental");
        return "userInterface/searchCars";
    }

    @GetMapping("/availableCars")
    public String availableCars(Model model, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate){
        // add advanced search
        model.addAttribute("title", "Available Cars");
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        List<Car> availableCars = reservationService.findAvailableCarsForPeriod(startDate, endDate);
        model.addAttribute("availableCars", availableCars);
        return "userInterface/availableCars";
    }

    @GetMapping("/deal")
    public String deal(Model model, @RequestParam LocalDate startDate, @RequestParam LocalDate endDate, @RequestParam Integer id){
        model.addAttribute("title", "Reservation");

        Car car = reservationService.findCarById(id);
        model.addAttribute("car", car);

        Integer reservationDuration = endDate.getDayOfYear() - startDate.getDayOfYear();
        model.addAttribute("reservationDuration", reservationDuration);

        Double totalCost = reservationDuration * car.getPricePerDay();
        model.addAttribute("totalCost", totalCost);


        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);

        return "userInterface/deal";
    }

    @PostMapping("/reservation")
    public String makeReservation(Model model, @RequestParam Integer id, @RequestParam LocalDate startDate,
                                  @RequestParam LocalDate endDate, @RequestParam String name, @RequestParam String lastName,
                                  @RequestParam String email, @RequestParam String address, @RequestParam String phone){
        ResponseEntity response = reservationService.makeReservation(id, startDate, endDate, name, lastName, email, address, phone);
        if(response.getStatusCode().isError()){
            model.addAttribute("title", "Error");
            model.addAttribute("message", response.getBody());
            model.addAttribute("text", "Please try again later");
        }else{
            model.addAttribute("title", "Successfully Reserved.");
            model.addAttribute("message", "Successfully Reserved.");
            model.addAttribute("text", response.getBody());
        }

        model.addAttribute("endDate", endDate);
        model.addAttribute("startDate", startDate);
        return "userInterface/reservation";
    }
}
