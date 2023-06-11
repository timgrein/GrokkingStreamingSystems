package com.streamwork.ch02.job;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Operator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class VehicleCountPrinter extends Operator {

    public VehicleCountPrinter(String name) {
        super(name);
    }

    @Override
    public void apply(Event event, List<Event> eventCollector) {
        System.out.println("Vehicle count:");
        VehicleCountInfo vehicleCountInfo = (VehicleCountInfo) event.getData();
        printVehicleCountInfo(vehicleCountInfo);
    }

    private void printVehicleCountInfo(VehicleCountInfo vehicleCountInfo){
        Map<String, Integer> countMap = vehicleCountInfo.getVehicleCount();

        List<String> vehicles = new ArrayList<>(countMap.keySet());
        Collections.sort(vehicles);

        for (String vehicle: vehicles) {
            System.out.println("  " + vehicle + ": " + countMap.get(vehicle));
        }

        System.out.printf("Total fees: %d\n", vehicleCountInfo.getTotalFees());
    }
}
