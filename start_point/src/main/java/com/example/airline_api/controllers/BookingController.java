package com.example.airline_api.controllers;

import com.example.airline_api.models.Booking;
import com.example.airline_api.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Display all bookings
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings(){
        List<Booking> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    // Add details of a new booking
    @PostMapping
    public ResponseEntity<Booking> addNewBooking(@RequestBody Booking booking){
        Booking newBooking = bookingService.saveBooking(booking);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    // Book passenger on a flight
    @PatchMapping(value = "/{flightId}/passengers/{passengerId}")
    public ResponseEntity<Booking> addPassengerToFlight(@PathVariable Long flightId, @PathVariable Long passengerId, @RequestBody Booking bookingDetails){
        Optional<Booking> bookingOptional = bookingService.getBookingById(bookingDetails.getId());
        if (!bookingOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Booking booking = bookingOptional.get();
        booking.setFlightId(flightId);
        booking.setPassengerId(passengerId);
        Booking updatedBooking = bookingService.saveBooking(booking);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }

    // Extension: Update passenger meal preference
    @PatchMapping("/{id}/mealPreference")
    public ResponseEntity<Booking> updateMealPreference(@PathVariable Long id, @RequestBody String mealPreference){
        Optional<Booking> bookingOptional = bookingService.getBookingById(id);
        if (!bookingOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Booking booking = bookingOptional.get();
        booking.setMealPreference(mealPreference);
        Booking updatedBooking = bookingService.saveBooking(booking);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }
}
