package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private FlightRepository flightRepository;



    @Transactional
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Transactional
    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).get();
    }


    public Passenger addPassenger(Passenger passenger) {
        return passenger;
    }

    @Transactional
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
}