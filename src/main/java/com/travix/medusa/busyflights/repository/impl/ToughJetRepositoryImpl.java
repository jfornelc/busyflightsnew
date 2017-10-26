package com.travix.medusa.busyflights.repository.impl;

import com.travix.medusa.busyflights.domain.SuppliersResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.repository.BusyFlightsRepository;
import com.travix.medusa.busyflights.repository.converter.BusyFlightsConverter;
import com.travix.medusa.busyflights.repository.validator.BusyFlightsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Repository
public class ToughJetRepositoryImpl extends BusyFlightsRepository {

    @Value("${url.thoughjet}")
    private String url;

    @Autowired
    public ToughJetRepositoryImpl(BusyFlightsConverter busyFlightsConverter, BusyFlightsValidator busyFlightsValidator, RestTemplate restTemplate) {
        super(busyFlightsConverter, busyFlightsValidator, restTemplate);
    }

    @Override
    public SuppliersResponse[] search(BusyFlightsRequest request) {
        ToughJetRequest toughJetRequest = this.busyFlightsConverter.toToughJetRequest(request);

        SuppliersResponse[] suppliersResponses = getToughJetSupplier(toughJetRequest);

        return suppliersResponses;
    }

    public SuppliersResponse[] getToughJetSupplier(@Valid ToughJetRequest toughJetRequest) {
        return this.getSupplierResponse(url, ToughJetResponse[].class, toughJetRequest.getSupplierParameters());
    }
}
