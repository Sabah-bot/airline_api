package com.example.airline_api.services;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.BookingRepository;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {


    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private BookingRepository bookingRepository;


    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> addPassengerToFlight(Long passengerId) {
        return bookingRepository.findAll();
    }


    public Booking addNewBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void saveBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
