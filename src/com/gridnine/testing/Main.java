package com.gridnine.testing;

import com.gridnine.testing.model.*;
import com.gridnine.testing.rules.*;
import com.gridnine.testing.service.*;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        List<Flight> flights = new ArrayList<>(FlightBuilder.createFlights());

        System.out.println("Raw List:\n");
        Printer.printList(flights);

        List<FlightRulesInterface> rules = new ArrayList<>();
        rules.add(new NoDepartureBeforeNow());
        rules.add(new NoArrivalBeforeDeparture());
        rules.add(new NoGroundTimeExceedingTwoHours());

        for(FlightRulesInterface r: rules){
            r.applyRule(flights);
        }
    }
}
