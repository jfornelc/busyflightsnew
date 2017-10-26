package com.travix.medusa.busyflights.repository;

import com.travix.medusa.busyflights.domain.SuppliersResponse;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.exceptionhandler.CustomException;
import com.travix.medusa.busyflights.repository.converter.BusyFlightsConverter;
import com.travix.medusa.busyflights.repository.validator.BusyFlightsValidator;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public abstract class BusyFlightsRepository {

    protected BusyFlightsConverter busyFlightsConverter;

    private BusyFlightsValidator busyFlightsValidator;

    private RestTemplate restTemplate;

    public BusyFlightsRepository(BusyFlightsConverter busyFlightsConverter, BusyFlightsValidator busyFlightsValidator, RestTemplate restTemplate) {
        this.busyFlightsConverter = busyFlightsConverter;
        this.busyFlightsValidator = busyFlightsValidator;
        this.restTemplate = restTemplate;
    }

    public abstract SuppliersResponse[] search(BusyFlightsRequest request);

    protected <T, R extends T> T getSupplierResponse(String urlTemplate, Class<R> responseType, Object[] uriArguments) {
        T supplierResponse = this.restTemplate.getForObject(urlTemplate, responseType, uriArguments);

        List<String> validators = busyFlightsValidator.checkResponses(supplierResponse);

        if (validators != null && validators.size() > 0) {
            throw new CustomException(HttpStatus.BAD_REQUEST.value(), validators.toString());
        }

        return supplierResponse;
    }

}
