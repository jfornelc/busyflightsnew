package com.travix.medusa.busyflights.mock;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.repository.impl.CrazyAirRepositoryImpl;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BusyFlightsMock {

    static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static String date1 = "20/10/2017";
    static String date2 = "26/10/2017";

    static DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    static String dateTime1 = "2017-10-20 00:00";
    static String dateTime2 = "2017-10-26 00:00";

    static String dateTime3 = "2017-10-20T00:00:00Z";
    static String dateTime4 = "2017-10-26T00:00:00Z";

    public static CrazyAirRequest getCrazyAirRequestMock(){
        CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
        crazyAirRequest.setOrigin("TOU");
        crazyAirRequest.setDestination("UOT");
        crazyAirRequest.setReturnDate(LocalDate.parse(date2, formatter1));
        crazyAirRequest.setDepartureDate(LocalDate.parse(date1, formatter1));
        crazyAirRequest.setPassengerCount(100);

        return crazyAirRequest;
    }

    public static BusyFlightsRequest getBusyFlightsRequestMock(){
        BusyFlightsRequest busyFlightsRequest = new BusyFlightsRequest();
        busyFlightsRequest.setOrigin("TOU");
        busyFlightsRequest.setDestination("UOT");
        busyFlightsRequest.setReturnDate(LocalDate.parse(date2, formatter1));
        busyFlightsRequest.setDepartureDate(LocalDate.parse(date1, formatter1));
        busyFlightsRequest.setNumberOfPassengers(100);

        return busyFlightsRequest;
    }

    public static ToughJetRequest getToughJetRequestMock(){
        ToughJetRequest toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom("TOU");
        toughJetRequest.setTo("UOT");
        toughJetRequest.setInboundDate(LocalDate.parse(date2, formatter1));
        toughJetRequest.setOutboundDate(LocalDate.parse(date1, formatter1));
        toughJetRequest.setNumberOfAdults(100);

        return toughJetRequest;
    }

    public static CrazyAirResponse getCrazyAirResponseMock(){
        CrazyAirResponse crazyAirResponse = new CrazyAirResponse();
        crazyAirResponse.setAirline("ABC");
        crazyAirResponse.setArrivalDate(LocalDateTime.parse(dateTime2, formatter2));
        crazyAirResponse.setDepartureDate(LocalDateTime.parse(dateTime1, formatter2));
        crazyAirResponse.setCabinclass("A");
        crazyAirResponse.setDepartureAirportCode("TOU");
        crazyAirResponse.setDestinationAirportCode("UOT");
        crazyAirResponse.setPrice(1000.0d);

        return crazyAirResponse;
    }

    public static ToughJetResponse getToughJetResponseMock(){
        ToughJetResponse toughJetResponse = new ToughJetResponse();
        toughJetResponse.setDepartureAirportName("TOU");
        toughJetResponse.setArrivalAirportName("UOT");
        toughJetResponse.setCarrier("ABC");
        toughJetResponse.setBasePrice(1000.0d);
        toughJetResponse.setDiscount(10);
        toughJetResponse.setTax(10);
        toughJetResponse.setInboundDateTime(Instant.parse(dateTime3));
        toughJetResponse.setOutboundDateTime(Instant.parse(dateTime4));

        return toughJetResponse;
    }
}
