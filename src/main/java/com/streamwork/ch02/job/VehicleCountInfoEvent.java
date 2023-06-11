package com.streamwork.ch02.job;

import com.streamwork.ch02.api.Event;

public class VehicleCountInfoEvent extends Event {

    private final VehicleCountInfo vehicleCountInfo;

    public VehicleCountInfoEvent(VehicleCountInfo vehicleCountInfo) {
        this.vehicleCountInfo = vehicleCountInfo;
    }

    @Override
    public Object getData() {
        return vehicleCountInfo;
    }
}
