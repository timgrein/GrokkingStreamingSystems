package com.streamwork.ch02.job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Operator;

class VehicleCounter extends Operator {
  private final Map<String, Integer> countMap = new HashMap<>();
  private final Map<String, Integer> vehicleTypeToFees = Map.of("car", 20, "truck", 50, "bike", 10);

  private Integer totalFees;

  public VehicleCounter(String name) {
    super(name);
    this.totalFees = 0;
  }

  @Override
  public void apply(Event vehicleEvent, List<Event> eventCollector) {
    String vehicle = ((VehicleEvent)vehicleEvent).getData();

    Integer count = countMap.getOrDefault(vehicle, 0) + 1;
    countMap.put(vehicle, count);
    this.totalFees += vehicleTypeToFees.get(vehicle);

    VehicleCountInfo vehicleCountInfo = new VehicleCountInfo(countMap, totalFees);
    eventCollector.add(new VehicleCountInfoEvent(vehicleCountInfo));
  }

}
