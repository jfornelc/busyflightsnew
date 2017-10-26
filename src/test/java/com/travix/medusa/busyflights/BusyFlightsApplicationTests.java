package com.travix.medusa.busyflights;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.util.Functions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestPropertySource("classpath:application-test.properties")
public class BusyFlightsApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	private final String CRAZY_AIR = "CrazyAir";
	private final String TOUGH_JET = "ToughJet";

	private LocalDateTime thoughJetDeparture;
	private LocalDateTime thoughJetArrival;

	private LocalDateTime crazyAirDeparture;
	private LocalDateTime crazyAirArrival;

	@Value("${busyflights.url.search}")
	String search;

	BusyFlightsResponse[] sut;

	@Before
	public void setUp(){
		sut = restTemplate.getForObject(search , BusyFlightsResponse[].class);
		thoughJetDeparture = Functions.generateLocalDateTime("2017-08-17T01:33:56.123");
		thoughJetArrival = Functions.generateLocalDateTime("2017-09-26T09:24:45.455");
		crazyAirDeparture = Functions.generateLocalDateTime("2017-10-17T07:42:42.731");
		crazyAirArrival = Functions.generateLocalDateTime("2017-12-22T11:31:58.642");
	}

	@Test
	public void busyFlightsFirstResult() throws Exception {
		BusyFlightsResponse sut = this.sut[0];
		assertThat(sut.getAirline()).isEqualTo("TOU1");
		assertThat(sut.getSupplier()).isEqualTo(TOUGH_JET);
		assertThat(sut.getFare()).isEqualTo(37.67);
		assertThat(sut.getDepartureAirportCode()).isEqualTo("TOU");
		assertThat(sut.getDestinationAirportCode()).isEqualTo("UOT");
		assertThat(sut.getDepartureDate()).isEqualTo(thoughJetDeparture);
		assertThat(sut.getArrivalDate()).isEqualTo(thoughJetArrival);
	}

	@Test
	public void busyFlightsSecondResult() throws Exception {
		BusyFlightsResponse sut = this.sut[1];
		assertThat(sut.getAirline()).isEqualTo("CRA4");
		assertThat(sut.getSupplier()).isEqualTo(CRAZY_AIR);
		assertThat(sut.getFare()).isEqualTo(43.46);
		assertThat(sut.getDepartureAirportCode()).isEqualTo("CRA");
		assertThat(sut.getDestinationAirportCode()).isEqualTo("ARC");
		assertThat(sut.getDepartureDate()).isEqualTo(crazyAirDeparture);
		assertThat(sut.getArrivalDate()).isEqualTo(crazyAirArrival);
	}

	@Test
	public void busyFlightsThirdResult() throws Exception {
		BusyFlightsResponse sut = this.sut[2];
		assertThat(sut.getAirline()).isEqualTo("CRA3");
		assertThat(sut.getSupplier()).isEqualTo(CRAZY_AIR);
		assertThat(sut.getFare()).isEqualTo(45.58);
		assertThat(sut.getDepartureAirportCode()).isEqualTo("CRA");
		assertThat(sut.getDestinationAirportCode()).isEqualTo("ARC");
		assertThat(sut.getDepartureDate()).isEqualTo(crazyAirDeparture);
		assertThat(sut.getArrivalDate()).isEqualTo(crazyAirArrival);
	}

	@Test
	public void busyFlightsForthResult() throws Exception {
		BusyFlightsResponse sut = this.sut[3];
		assertThat(sut.getAirline()).isEqualTo("CRA1");
		assertThat(sut.getSupplier()).isEqualTo(CRAZY_AIR);
		assertThat(sut.getFare()).isEqualTo(47.11);
		assertThat(sut.getDepartureAirportCode()).isEqualTo("CRA");
		assertThat(sut.getDestinationAirportCode()).isEqualTo("ARC");
		assertThat(sut.getDepartureDate()).isEqualTo(crazyAirDeparture);
		assertThat(sut.getArrivalDate()).isEqualTo(crazyAirArrival);
	}

	@Test
	public void busyFlightsFifthResult() throws Exception {
		BusyFlightsResponse sut = this.sut[4];
		assertThat(sut.getAirline()).isEqualTo("CRA2");
		assertThat(sut.getSupplier()).isEqualTo(CRAZY_AIR);
		assertThat(sut.getFare()).isEqualTo(48.32);
		assertThat(sut.getDepartureAirportCode()).isEqualTo("CRA");
		assertThat(sut.getDestinationAirportCode()).isEqualTo("ARC");
		assertThat(sut.getDepartureDate()).isEqualTo(crazyAirDeparture);
		assertThat(sut.getArrivalDate()).isEqualTo(crazyAirArrival);
	}

	@Test
	public void busyFlightsSixthResult() throws Exception {
		BusyFlightsResponse sut = this.sut[5];
		assertThat(sut.getAirline()).isEqualTo("TOU3");
		assertThat(sut.getSupplier()).isEqualTo(TOUGH_JET);
		assertThat(sut.getFare()).isEqualTo(58.67);
		assertThat(sut.getDepartureAirportCode()).isEqualTo("TOU");
		assertThat(sut.getDestinationAirportCode()).isEqualTo("UOT");
		assertThat(sut.getDepartureDate()).isEqualTo(thoughJetDeparture);
		assertThat(sut.getArrivalDate()).isEqualTo(thoughJetArrival);
	}
}
