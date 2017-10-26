package com.travix.medusa.busyflights.domain;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.repository.converter.BusyFlightsConverter;

public interface SuppliersResponse {
    String getSupplierType();
    BusyFlightsResponse convertToBusyFlightResponse(BusyFlightsConverter converter);
}
