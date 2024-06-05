package com.example.airline_api.models;
import jakarta.persistence.*;


@Entity
@Table(name = "booking")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private int seatNumber;

    @Column
    private Passenger passenger;

    @Column
    private int flight;

    @Column
    private String mealPreference;


    public Booking(){

    }

    public Booking(int seatNumber, String mealPreference, Passenger passenger, int flight) {
        this.seatNumber = seatNumber;
        this.mealPreference = mealPreference;
        this.passenger =  passenger;
        this.flight = flight;
    }


//    GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight.getCapacity();
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getMealPreference() {
        return mealPreference;
    }

    public void setMealPreference(String mealPreference) {
        this.mealPreference = mealPreference;
    }

    public void setFlightId(Long flightId) {
    }

    public void setPassengerId(Long passengerId) {
    }
}
