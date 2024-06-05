package com.example.airline_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passengers")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "emailAddress")
    private String email;

    @ManyToMany(mappedBy = "passengers")
    @JsonIgnoreProperties("passengers")
    private List<Flight> flights = new ArrayList<>();


    // Constructors, getters, and setters

    public Passenger() {
    }

    public Passenger(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    // Add getters and setters for id, name, and email

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public void addFlight(Flight flight){
        this.flights.add(flight);
    }

    public void removeFlight(Flight flight){
        this.flights.remove(flight);
    }
}