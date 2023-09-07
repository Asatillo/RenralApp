package com.CarRental.CarRentalApplication.controller;

import com.CarRental.CarRentalApplication.model.Car;
import com.CarRental.CarRentalApplication.model.Reservation;
import com.CarRental.CarRentalApplication.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

        @Autowired
        AdminService adminService;

        @GetMapping("bookings")
        public String admin(Model model){
            model.addAttribute("title", "Admin");
            List<Reservation> reservations = adminService.getAllReservations();
            model.addAttribute("reservations", reservations);
            return "adminInterface/bookings";
        }

        @GetMapping("manageCars")
        public String manageCars(Model model){
            model.addAttribute("title", "Manage Cars");
            List<Car> cars = adminService.getAllCars();
            model.addAttribute("cars", cars);
            return "adminInterface/manageCars";
        }

        @GetMapping("deactivateCar/{id}")
        public String deactivateCar(Model model, @PathVariable Integer id){
            adminService.deactivateCar(id);
            return "adminInterface/manageCars";
        }

}
