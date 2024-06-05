package com.example.airline_api.repositories;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByPassenger(Passenger passenger); // Display all bookings

    Optional<Booking> findById(Long id); // Display specific booking

    List<Booking> findByPassengerId(Long passengerId); // Find all bookings by passenger

    List<Booking> findByFlightId(Long flightId); // Find all bookings by flight

    Booking save(Booking booking); // Save a new booking or update an existing one

}

