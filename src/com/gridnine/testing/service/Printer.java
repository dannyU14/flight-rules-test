package com.gridnine.testing.service;

import java.util.List;
import com.gridnine.testing.model.Flight;

public class Printer {
    public static void printList(List<Flight> flights) {
        for (Flight f: flights) {
            System.out.println(f + "\n***");
        }
    }
}
