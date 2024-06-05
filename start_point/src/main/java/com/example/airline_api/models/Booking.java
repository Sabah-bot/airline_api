package com.example.airline_api.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;


import java.util.List;
import java.util.Optional;


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

    @OneToMany(mappedBy = "booking") // Modified mappedBy to match property name
    @JsonIgnoreProperties({"booking"})
    private List<Booking> bookings; // Modified property name to match mappedBy


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



    public List<Booking> getAllBookings() {
        List<Booking> booking;
        return getAllBookings();
    }

    public List<Booking> addNewBooking() {
        List<Booking> booking;
        return addNewBooking();
    }

    public Booking addPassengerToFlight(Long bookingId, Long passengerId) {
        Optional<Booking> bookingOptional = getBookingById();
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setPassengerId(passengerId);
            return saveBooking();
        }
        return null; // or throw an exception
    }

    private Booking saveBooking() {
        return saveBooking();

    }

    private Optional<Booking> getBookingById() {
        return getBookingById();
    }


    public Booking updateMealPreference(Long bookingId, String mealPreference) {
        Optional<Booking> bookingOptional = getBookingById();
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setMealPreference(mealPreference);
            return saveBooking();
        }
        return null; // or throw an exception
    }

}