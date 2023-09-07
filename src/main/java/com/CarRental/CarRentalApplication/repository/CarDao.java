package com.CarRental.CarRentalApplication.repository;

import com.CarRental.CarRentalApplication.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface CarDao extends JpaRepository<Car, Integer> {

    @Query(value = "SELECT DISTINCT *\n" +
            "FROM car c\n" +
            "WHERE c.id NOT IN (\n" +
            "    SELECT DISTINCT car_id\n" +
            "    FROM reservation\n" +
            "    WHERE (status != 'returned' or status != NULL) and ((:startDate BETWEEN start_date AND end_date OR :endDate BETWEEN start_date AND end_date)\n" +
            "    OR (start_date BETWEEN :startDate AND :endDate)));\n", nativeQuery = true)
    List<Car> findAvailableCarsForPeriod(LocalDate startDate, LocalDate endDate);

}
