package com.gridnine.testing.rules;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;
import com.gridnine.testing.service.Printer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Filter class that returns the list of flights after -No Departure Before Now- rule was applied.
 */
public class NoDepartureBeforeNow implements FlightRulesInterface{

    @Override
    public List<Flight> applyRule(List<Flight> flights) {

        List<Flight> resultList = new ArrayList<>(flights);

        for (Flight f: flights) {
            for (Segment s: f.getSegments()) {
                if (s.getDepartureDate().isBefore(LocalDateTime.now())) {
                    resultList.remove(f);
                }
            }
        }

        System.out.println("List after -No Departure Before Now- rule was applied:\n");
        Printer.printList(resultList);

        return resultList;
    }
}
