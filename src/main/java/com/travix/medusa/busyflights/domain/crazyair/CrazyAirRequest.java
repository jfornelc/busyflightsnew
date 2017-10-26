package com.travix.medusa.busyflights.domain.crazyair;

import com.travix.medusa.busyflights.domain.SuppliersRequest;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CrazyAirRequest implements SuppliersRequest{

    @Size(min = 3, max = 3)
    private String origin;
    @Size(min = 3, max = 3)
    private String destination;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate departureDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate returnDate;
    private int passengerCount;

    public CrazyAirRequest() {

    }

    public CrazyAirRequest(String origin, String destination, LocalDate departureDate, LocalDate returnDate,
                           int passengerCount) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.passengerCount = passengerCount;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(final int passengerCount) {
        this.passengerCount = passengerCount;
    }

    @Override
    public Object[] getSupplierParameters() {
        List<String> out = new ArrayList<>();

        out.add(this.origin);
        out.add(this.destination);
        out.add(this.departureDate.toString());
        out.add(this.returnDate.toString());
        out.add(String.valueOf(this.passengerCount));

        return out.toArray();
    }

    @Override
    public String toString() {
        return "CrazyAirRequest{" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureDate=" + departureDate +
                ", returnDate=" + returnDate +
                ", passengerCount=" + passengerCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CrazyAirRequest that = (CrazyAirRequest) o;

        if (passengerCount != that.passengerCount) return false;
        if (!origin.equals(that.origin)) return false;
        if (!destination.equals(that.destination)) return false;
        if (!departureDate.equals(that.departureDate)) return false;
        return returnDate.equals(that.returnDate);
    }

    @Override
    public int hashCode() {
        int result = origin.hashCode();
        result = 31 * result + destination.hashCode();
        result = 31 * result + departureDate.hashCode();
        result = 31 * result + returnDate.hashCode();
        result = 31 * result + passengerCount;
        return result;
    }
}
