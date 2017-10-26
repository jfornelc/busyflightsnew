package com.travix.medusa.busyflights.repository.validator;

import com.travix.medusa.busyflights.domain.SuppliersResponse;

import java.util.List;

public interface BusyFlightsValidator<T> {

    List<String> checkResponses(T suppliersResponses);
}
