package com.travix.medusa.busyflights.domain.toughjet;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.travix.medusa.busyflights.deserializer.InstantDeserializer;
import com.travix.medusa.busyflights.domain.SuppliersResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.repository.converter.BusyFlightsConverter;
import com.travix.medusa.busyflights.serializer.InstantSerializer;

import javax.validation.constraints.Size;
import java.time.Instant;

public class ToughJetResponse implements SuppliersResponse {

    private String carrier;
    private double basePrice;
    private double tax;
    private double discount;
    @Size(min=3, max=3)
    private String departureAirportName;
    @Size(min=3, max=3)
    private String arrivalAirportName;
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    private Instant outboundDateTime;
    @JsonSerialize(using = InstantSerializer.class)
    @JsonDeserialize(using = InstantDeserializer.class)
    private Instant inboundDateTime;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(final String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(final double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(final double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(final double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(final String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(final String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public Instant getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(final Instant outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public Instant getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(final Instant inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }

    @Override
    public String getSupplierType() {
        return "ToughJet";
    }

    @Override
    public BusyFlightsResponse convertToBusyFlightResponse(BusyFlightsConverter converter) {
        return converter.getBusyFlightResponse(this);
    }

    @Override
    public String toString() {
        return "ToughJetResponse{" +
                "carrier='" + carrier + '\'' +
                ", basePrice=" + basePrice +
                ", tax=" + tax +
                ", discount=" + discount +
                ", departureAirportName='" + departureAirportName + '\'' +
                ", arrivalAirportName='" + arrivalAirportName + '\'' +
                ", outboundDateTime=" + outboundDateTime +
                ", inboundDateTime=" + inboundDateTime +
                '}';
    }

    public static Builder builder() {
        return new ToughJetResponse.Builder();
    }

    public static class Builder {
        private final ToughJetResponse instance = new ToughJetResponse();

        private Builder() {
        }

        public Builder carrier(String carrier) {
            instance.carrier = carrier;
            return this;
        }

        public Builder basePrice(double basePrice) {
            instance.basePrice = basePrice;
            return this;
        }

        public Builder tax(double tax) {
            instance.tax = tax;
            return this;
        }

        public Builder discount(double discount) {
            instance.discount = discount;
            return this;
        }

        public Builder departureAirportName(String departureAirportName) {
            instance.departureAirportName = departureAirportName;
            return this;
        }

        public Builder arrivalAirportName(String arrivalAirportName) {
            instance.arrivalAirportName = arrivalAirportName;
            return this;
        }

        public Builder outboundDateTime(Instant outboundDateTime) {
            instance.outboundDateTime = outboundDateTime;
            return this;
        }

        public Builder inboundDateTime(Instant inboundDateTime) {
            instance.inboundDateTime = inboundDateTime;
            return this;
        }

        public ToughJetResponse build() {
            return instance;
        }
    }
}
