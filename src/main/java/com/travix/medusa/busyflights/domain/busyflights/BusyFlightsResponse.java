package com.travix.medusa.busyflights.domain.busyflights;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.travix.medusa.busyflights.deserializer.LocalDateTimeDeserializer;
import com.travix.medusa.busyflights.serializer.LocalDateTimeSerializer;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class BusyFlightsResponse {
    private String airline;
    private String supplier;
    private double fare;
    @Size(min = 3, max = 3)
    private String departureAirportCode;
    @Size(min = 3, max = 3)
    private String destinationAirportCode;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime departureDate;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime arrivalDate;

    public BusyFlightsResponse() {

    }

    public BusyFlightsResponse(String airline, String supplier, double fare, String departureAirportCode,
                               String destinationAirportCode, LocalDateTime departureDate, LocalDateTime arrivalDate) {
        this.airline = airline;
        this.supplier = supplier;
        this.fare = fare;
        this.departureAirportCode = departureAirportCode;
        this.destinationAirportCode = destinationAirportCode;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    public String getAirline() {
        return airline;
    }

    public String getSupplier() {
        return supplier;
    }

    public double getFare() {
        return fare;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    @Override
    public String toString() {
        return "BusyFlightsResponse{" +
                "airline='" + airline + '\'' +
                ", supplier='" + supplier + '\'' +
                ", fare=" + fare +
                ", departureAirportCode='" + departureAirportCode + '\'' +
                ", destinationAirportCode='" + destinationAirportCode + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                '}';
    }
}
