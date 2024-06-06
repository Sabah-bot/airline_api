package com.example.airline_api.controllers;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.BookingDTO;
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

//    Add new booking
    @PostMapping(value = "/{id}")
    public ResponseEntity<Booking> addNewBooking(@RequestBody BookingDTO bookingDTO){
        Booking booking = bookingService.addNewBooking(bookingDTO);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
    // Book passenger on a flight
    @PatchMapping(value = "/{flightId}/passengers/{passengerId}")
    public ResponseEntity<Booking> addPassengerToFlight(@PathVariable Long flightId, @PathVariable Long passengerId, @RequestBody Booking bookingDetails){
        Optional<Booking> bookingOptional = bookingService.getBookingById(bookingDetails.getId());
        if (!bookingOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

//        AddPassengerToFlight


//        getAllBookings




//        Save booking
        Booking booking = bookingOptional.get();
        booking.setFlightId(flightId);
        booking.setPassengerId(passengerId);
        Booking updatedBooking = bookingService.saveBooking(booking);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }


}
