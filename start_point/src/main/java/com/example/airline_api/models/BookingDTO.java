package com.example.airline_api.models;

import com.example.airline_api.repositories.BookingRepository;

public class BookingDTO {

    private long flightID;

    private long passengerId;


    public BookingDTO(long flightID, long passengerId){

    }


    public BookingDTO(){

    }


    public long getFlightID() {
        return flightID;
    }

    public void setFlightID(long flightID) {
        this.flightID = flightID;
    }

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }
}
