package com.gridnine.testing.rules;

import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface for all flight rules.
 */

public interface FlightRulesInterface {

    List<Flight> applyRule(List<Flight> flights);
}
