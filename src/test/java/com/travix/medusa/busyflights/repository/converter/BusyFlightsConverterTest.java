package com.travix.medusa.busyflights.repository.converter;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.repository.converter.BusyFlightsConverter;

@RunWith(SpringRunner.class)

public class BusyFlightsConverterTest {

    @InjectMocks
    private BusyFlightsConverter busyFlightsConverter;

    private CrazyAirRequest crazyAirRequest;

    private BusyFlightsRequest busyFlightsRequest;

    private ToughJetRequest toughJetRequest;

    private BusyFlightsResponse busyFlightsResponse;

    private CrazyAirResponse crazyAirResponse;

    private ToughJetResponse toughJetResponse;


    @Before
    public void setUpObjects(){

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date1 = "20/10/2017";
        String date2 = "26/10/2017";

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String dateTime1 = "2017-10-20 00:00";
        String dateTime2 = "2017-10-26 00:00";

        String dateTime3 = "2017-10-20T00:00:00Z";
        String dateTime4 = "2017-10-26T00:00:00Z";

        crazyAirRequest = new CrazyAirRequest();
        crazyAirRequest.setOrigin("TOU");
        crazyAirRequest.setDestination("UOT");
        crazyAirRequest.setReturnDate(LocalDate.parse(date2, formatter1));
        crazyAirRequest.setDepartureDate(LocalDate.parse(date1, formatter1));
        crazyAirRequest.setPassengerCount(100);

        System.out.println(crazyAirRequest.getDepartureDate());

        busyFlightsRequest = new BusyFlightsRequest();
        busyFlightsRequest.setOrigin("TOU");
        busyFlightsRequest.setDestination("UOT");
        busyFlightsRequest.setReturnDate(LocalDate.parse(date2, formatter1));
        busyFlightsRequest.setDepartureDate(LocalDate.parse(date1, formatter1));
        busyFlightsRequest.setNumberOfPassengers(100);

        System.out.println(busyFlightsRequest.getDepartureDate());

        toughJetRequest = new ToughJetRequest();
        toughJetRequest.setFrom("TOU");
        toughJetRequest.setTo("UOT");
        toughJetRequest.setInboundDate(LocalDate.parse(date2, formatter1));
        toughJetRequest.setOutboundDate(LocalDate.parse(date1, formatter1));
        toughJetRequest.setNumberOfAdults(100);

        crazyAirResponse = new CrazyAirResponse();
        crazyAirResponse.setAirline("ABC");
        crazyAirResponse.setArrivalDate(LocalDateTime.parse(dateTime2, formatter2));
        crazyAirResponse.setDepartureDate(LocalDateTime.parse(dateTime1, formatter2));
        crazyAirResponse.setCabinclass("A");
        crazyAirResponse.setDepartureAirportCode("TOU");
        crazyAirResponse.setDestinationAirportCode("UOT");
        crazyAirResponse.setPrice(1000.0d);

        toughJetResponse = new ToughJetResponse();
        toughJetResponse.setDepartureAirportName("TOU");
        toughJetResponse.setArrivalAirportName("UOT");
        toughJetResponse.setCarrier("ABC");
        toughJetResponse.setBasePrice(1000.0d);
        toughJetResponse.setDiscount(10);
        toughJetResponse.setTax(10);
        toughJetResponse.setInboundDateTime(Instant.parse(dateTime3));
        toughJetResponse.setOutboundDateTime(Instant.parse(dateTime4));

    }

    @Test
    public void toCrazyAirRequestTest(){
        assertEquals(crazyAirRequest, busyFlightsConverter.toCrazyAirRequest(busyFlightsRequest));
    }

    @Test
    public void toToughJetRequestTest(){

        assertEquals(toughJetRequest, busyFlightsConverter.toToughJetRequest(busyFlightsRequest));
    }

    @Test
    public void getBusyFlightResponseFromCrazyAirResponseTest(){

        BusyFlightsResponse busyFlightsResponse = busyFlightsConverter.getBusyFlightResponse(crazyAirResponse);
        System.out.println("Date is "+busyFlightsResponse.getArrivalDate());
        assertEquals("TOU", busyFlightsResponse.getDepartureAirportCode());
        assertEquals("UOT", busyFlightsResponse.getDestinationAirportCode());
        assertEquals(1000.0d, busyFlightsResponse.getFare(), 0.01);
        assertEquals("ABC", busyFlightsResponse.getAirline());
        assertEquals(LocalDateTime.parse("2017-10-20T00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")), busyFlightsResponse.getDepartureDate());
        assertEquals(LocalDateTime.parse("2017-10-26T00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")), busyFlightsResponse.getArrivalDate());
    }

    @Test
    public void getBusyFlightResponseFromToughJetResponseTest(){

        BusyFlightsResponse busyFlightsResponse = busyFlightsConverter.getBusyFlightResponse(toughJetResponse);
        System.out.println(busyFlightsResponse.getArrivalDate());
        assertEquals("TOU", busyFlightsResponse.getDepartureAirportCode());
        assertEquals("UOT", busyFlightsResponse.getDestinationAirportCode());
        assertEquals("ABC", busyFlightsResponse.getAirline());
        assertEquals(LocalDateTime.parse("2017-10-20T00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")), busyFlightsResponse.getArrivalDate());
        assertEquals(LocalDateTime.parse("2017-10-26T00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")), busyFlightsResponse.getDepartureDate());
        assertEquals(9900.0, busyFlightsResponse.getFare(), 0.01);
    }
}
