package com.travix.medusa.busyflights.repository.impl;

import com.travix.medusa.busyflights.domain.SuppliersResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.repository.BusyFlightsRepository;
import com.travix.medusa.busyflights.repository.converter.BusyFlightsConverter;
import com.travix.medusa.busyflights.repository.validator.BusyFlightsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Repository
public class CrazyAirRepositoryImpl extends BusyFlightsRepository {

    @Value("${url.crazyair}")
    private String url;

    @Autowired
    public CrazyAirRepositoryImpl(BusyFlightsConverter busyFlightsConverter, BusyFlightsValidator busyFlightsValidator, RestTemplate restTemplate) {
        super(busyFlightsConverter, busyFlightsValidator, restTemplate);
    }

    @Override
    public SuppliersResponse[] search(BusyFlightsRequest request) {
        CrazyAirRequest crazyAirRequest = this.busyFlightsConverter.toCrazyAirRequest(request);


        return getCrazyAirSupplier(crazyAirRequest);
    }

    public SuppliersResponse[] getCrazyAirSupplier(@Valid CrazyAirRequest crazyAirRequest) {
        return this.getSupplierResponse(url, CrazyAirResponse[].class,
                crazyAirRequest.getSupplierParameters());
    }


}
