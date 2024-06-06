package com.example.airline_api.repositories;

import com.example.airline_api.models.Booking;
import com.example.airline_api.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {


}

