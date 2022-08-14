package com.harmonengineering.beans;

import java.util.Date;

public class FlightDetailBean
{
    private String departureCity ; // departing city
    private String arrivalCity ;// arrival city
    private Date   travelDate ; // travel date
    private String  airlineName ; // airline
    private int     requiredSeats ;// requested seats

    public void setDepartureCity(String departureCity) { this.departureCity = departureCity; }
    public void setArrivalCity(String arrivalCity) { this.arrivalCity = arrivalCity; }
    public void setTravelDate(Date travelDate) { this.travelDate = travelDate;  }
    public void setAirlineName(String airlineName) { this.airlineName = airlineName; }
    public void setRequiredSeats(int requiredSeats) {this.requiredSeats = requiredSeats; }

    public String getDepartureCity() { return departureCity; }
    public String getArrivalCity() { return arrivalCity; }
    public Date getTravelDate() {  return travelDate;}
    public String getAirlineName() { return airlineName;  }
    public int getRequiredSeats() { return requiredSeats; }
}
