package com.travix.medusa.busyflights.repository.converter;

import static org.junit.Assert.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.travix.medusa.busyflights.mock.BusyFlightsMock;
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
        crazyAirRequest = BusyFlightsMock.getCrazyAirRequestMock();
        busyFlightsRequest = BusyFlightsMock.getBusyFlightsRequestMock();
        toughJetRequest = BusyFlightsMock.getToughJetRequestMock();
        crazyAirResponse = BusyFlightsMock.getCrazyAirResponseMock();
        toughJetResponse = BusyFlightsMock.getToughJetResponseMock();
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
