package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
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

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Flight singapore = new Flight("Singapore", 400, "2024-02-14", "08:00:00");
        flightService.addNewFlight(singapore);

        Flight Mumbai = new Flight("Mumbai", 250, "2024-05-21", "16:30:00");
        flightService.addNewFlight(Mumbai);

        Flight New_York = new Flight("NYC", 200, "2024-08-24", "23:00:00");
        flightService.addNewFlight(New_York);

        Passenger Sabrina = new Passenger("Sabrina", "Sabrina-emails@youcanseethis.co.uk");
        passengerService.addNewPassenger(Sabrina);

        Passenger Gracie = new Passenger("Gracie", "gracie@missme.co.uk");
        passengerService.addNewPassenger(Gracie);

        Passenger olivia = new Passenger("Olivia", "Olivia@driverslicense.co.uk");
        passengerService.addNewPassenger(olivia);

        Passenger conan = new Passenger("Conan", "conan@healthersweatshirtcryingclub.co.uk");
        passengerService.addNewPassenger(conan);

    }
}
