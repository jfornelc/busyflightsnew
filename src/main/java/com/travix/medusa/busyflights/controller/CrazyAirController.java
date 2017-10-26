package com.travix.medusa.busyflights.controller;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.util.Functions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CrazyAirController {

    @RequestMapping(value = "/search/crazyair", method = RequestMethod.GET)
    public ResponseEntity<List<CrazyAirResponse>> crazyAirSearch() {

        List<CrazyAirResponse> crazyAirResponses = new ArrayList<>();

        LocalDateTime dateDeparture = Functions.generateLocalDateTime("2017-10-17T07:42:42.731");
        LocalDateTime dateArrival = Functions.generateLocalDateTime("2017-12-22T11:31:58.642");

        crazyAirResponses.add(new CrazyAirResponse("CRA1", 47.11, "A", "CRA",
                "ARC", dateDeparture, dateArrival));
        crazyAirResponses.add(new CrazyAirResponse("CRA2", 48.32, "B", "CRA",
                "ARC", dateDeparture, dateArrival));
        crazyAirResponses.add(new CrazyAirResponse("CRA3", 45.58, "C", "CRA",
                "ARC", dateDeparture, dateArrival));
        crazyAirResponses.add(new CrazyAirResponse("CRA4", 43.46, "D", "CRA",
                "ARC", dateDeparture, dateArrival));

        return new ResponseEntity<>(crazyAirResponses, HttpStatus.OK);
    }

}
