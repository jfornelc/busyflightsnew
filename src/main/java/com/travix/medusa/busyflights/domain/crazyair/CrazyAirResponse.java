package com.travix.medusa.busyflights.domain.crazyair;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.travix.medusa.busyflights.deserializer.LocalDateTimeDeserializer;
import com.travix.medusa.busyflights.domain.SuppliersResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.repository.converter.BusyFlightsConverter;
import com.travix.medusa.busyflights.serializer.LocalDateTimeSerializer;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class CrazyAirResponse implements SuppliersResponse {

    private String airline;
    private double price;
    private String cabinclass;
    @Size(min=3, max=3)
    private String departureAirportCode;
    @Size(min=3, max=3)
    private String destinationAirportCode;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime departureDate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime arrivalDate;

    public CrazyAirResponse(){

    }

    public CrazyAirResponse(String airline, double price, String cabinclass, String departureAirportCode,
                            String destinationAirportCode, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.airline = airline;
        this.price = price;
        this.cabinclass = cabinclass;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(final String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(final String cabinclass) {
        this.cabinclass = cabinclass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(final String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(final String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(final LocalDateTime arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public String getSupplierType() {
        return "CrazyAir";
    }

    @Override
    public BusyFlightsResponse convertToBusyFlightResponse(BusyFlightsConverter converter) {
        return converter.getBusyFlightResponse(this);
    }

    @Override
    public String toString() {
        return "CrazyAirResponse{" +
                "airline='" + airline + '\'' +
                ", price=" + price +
                ", cabinclass='" + cabinclass + '\'' +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
