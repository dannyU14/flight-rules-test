package com.gridnine.testing.rules;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.Printer;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Filter class that returns the list of flights after -No Ground Time Exceeding Two Hours- rule was applied.
 */

public class NoGroundTimeExceedingTwoHours implements FlightRulesInterface{

    @Override
    public List<Flight> applyRule(List<Flight> flights) {

        List<Flight> resultList = new ArrayList<>(flights);

        for (Flight f: flights) {
            long hours = 0;

            for (int i = 0; i < f.getSegments().size() - 1; i++) {
                LocalDateTime arrivalTime = f.getSegments().get(i).getArrivalDate();
                LocalDateTime departureTime = f.getSegments().get(i + 1).getDepartureDate();
                long groundTime = Duration.between(arrivalTime, departureTime).toHours();
                hours += groundTime;
            }
            if (hours > 2) {
                resultList.remove(f);
            }
        }

        System.out.println("List after -No Ground Time Exceeding Two Hours- rule was applied:\n");
        Printer.printList(resultList);

        return resultList;
    }
}
