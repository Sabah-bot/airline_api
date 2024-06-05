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

        // Create Passengers
        Passenger passenger1 = new Passenger("John Lockers", "john.doe@example.com");
        passengerService.savePassenger(passenger1);

        Passenger passenger2 = new Passenger("Jane Cheevers", "jane.smith@example.com");
        passengerService.savePassenger(passenger2);

        Passenger passenger3 = new Passenger("Sabrina Dondon", "alice.johnson@example.com");
        passengerService.savePassenger(passenger3);

        // Create Bookings
        Booking booking1 = new Booking(12, "Vegetarian", passenger1, 3);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking(14, "Halal", passenger2, 4);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking(6, "Vegan", passenger3, 2);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking(5, "Gluten-Free", passenger1, 2);
        bookingRepository.save(booking4);

        Booking booking5 = new Booking(56, "Halal", passenger2, 2);
        bookingRepository.save(booking5);
    }
}
