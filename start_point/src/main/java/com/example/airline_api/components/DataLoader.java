package com.example.airline_api.components;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.services.FlightService;
import com.example.airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FlightService flightService;

    @Autowired
    PassengerService passengerService;

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create Flights
        Flight flight1 = new Flight("Singapore", 200, LocalDate.of(2024, 7, 20), LocalTime.of(14, 30));
        flightService.saveFlight(flight1);

        Flight flight2 = new Flight("London", 150, LocalDate.of(2024, 8, 15), LocalTime.of(9, 45));
        flightService.saveFlight(flight2);

        Flight flight3 = new Flight("Kuala Lumpar", 180, LocalDate.of(2024, 9, 10), LocalTime.of(16, 00));
        flightService.saveFlight(flight3);


    }

}
