package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.util.Functions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ToughJetController {

    @RequestMapping(value = "/search/toughjet", method = RequestMethod.GET)
    public ResponseEntity<List<ToughJetResponse>> toughJetSearch() {
        List<ToughJetResponse> toughJetResponses = new ArrayList<>();

        toughJetResponses.add(createToughJet("TOU1", 30.11));
        toughJetResponses.add(createToughJet("TOU2", 67.11));
        toughJetResponses.add(createToughJet("TOU3", 44.11));
        toughJetResponses.add(createToughJet("TOU4", 58.11));

        return new ResponseEntity<>(toughJetResponses, HttpStatus.OK);
    }

    private ToughJetResponse createToughJet(String strCarrier, double bPrice) {
        Instant departureDate = Functions.generateInstant("2017-08-17T01:33:56.123Z");
        Instant arrivalDate = Functions.generateInstant("2017-09-26T09:24:45.455Z");
        return ToughJetResponse.builder().carrier(strCarrier).basePrice(bPrice).tax(1.50)
                .discount(5).departureAirportName("TOU").arrivalAirportName("UOT").outboundDateTime(departureDate)
                .inboundDateTime(arrivalDate).build();
    }


}
