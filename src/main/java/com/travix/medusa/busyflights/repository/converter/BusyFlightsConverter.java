package com.travix.medusa.busyflights.repository.converter;

import com.travix.medusa.busyflights.domain.SuppliersResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Component
public class BusyFlightsConverter{
    public CrazyAirRequest toCrazyAirRequest(BusyFlightsRequest req) {
        return new CrazyAirRequest(req.getOrigin(), req.getDestination(), req.getDepartureDate(), req.getReturnDate(),
                req.getNumberOfPassengers());
    }

    public ToughJetRequest toToughJetRequest(BusyFlightsRequest req) {
        return new ToughJetRequest(req.getOrigin(), req.getDestination(), req.getDepartureDate(), req.getReturnDate(),
                req.getNumberOfPassengers());
    }

    public BusyFlightsResponse getBusyFlightResponse(CrazyAirResponse res){
        return new BusyFlightsResponse(res.getAirline(), res.getSupplierType(), res.getPrice(), res.getDepartureAirportCode(),
                res.getDestinationAirportCode(), res.getDepartureDate(), res.getArrivalDate());
    }

    public BusyFlightsResponse getBusyFlightResponse(ToughJetResponse res){
        double price = roundDecimal((res.getBasePrice() - res.getDiscount()) * res.getTax());
        LocalDateTime outbound = LocalDateTime.ofInstant(res.getOutboundDateTime(), ZoneOffset.UTC);
        LocalDateTime inbound = LocalDateTime.ofInstant(res.getInboundDateTime(), ZoneOffset.UTC);
        return new BusyFlightsResponse(res.getCarrier(), res.getSupplierType(), price, res.getDepartureAirportName(),
                res.getArrivalAirportName(), outbound, inbound);
    }

    public BusyFlightsResponse toBusyFlightResponse(SuppliersResponse res) {
        return res.convertToBusyFlightResponse(this);
    }

    private double roundDecimal(double value){
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
