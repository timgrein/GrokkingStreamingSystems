package com.streamwork.ch02.job;

import java.util.Map;

public class VehicleCountInfo {

    private final Map<String, Integer> vehicleCount;
    private final Integer totalFees;

    public VehicleCountInfo(Map<String, Integer> vehicleCount, Integer totalFees) {
        this.vehicleCount = vehicleCount;
        this.totalFees = totalFees;
    }

    public Map<String, Integer> getVehicleCount() {
        return vehicleCount;
    }

    public Integer getTotalFees() {
        return totalFees;
    }
}
