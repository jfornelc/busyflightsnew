package com.travix.medusa.busyflights.repository.validator.impl;

import com.travix.medusa.busyflights.domain.SuppliersResponse;
import com.travix.medusa.busyflights.repository.validator.BusyFlightsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class BusyFlightsBusyFlightsValidator implements BusyFlightsValidator<SuppliersResponse[]> {

    @Autowired
    public Validator validator;

    @Override
    public List<String> checkResponses(SuppliersResponse[] suppliersResponses) {
        return validate(suppliersResponses);
    }

    public List<String> validate(SuppliersResponse[] suppliersResponses){
        List<String> suppliersResponse = Arrays.stream(suppliersResponses)
                .map(item -> this.validateSupplier(item)).flatMap(List::stream)
                .collect(Collectors.toList());

        return suppliersResponse;
    }

    private List<String> validateSupplier(SuppliersResponse suppliersResponse) {
        Set<ConstraintViolation<SuppliersResponse>> violations = this.validator.validate(suppliersResponse);
        return violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }
}
