package com.streamwork.ch02.job;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Source;

class SensorReader extends Source {
  private final BufferedReader reader;
  private final List<String> vehicleTypes = List.of("car", "truck", "bike");

  public SensorReader(String name, int port) {
    super(name);

    reader = setupSocketReader(port);
  }

  @Override
  public void getEvents(List<Event> eventCollector) {
    try {
      String randomVehicleType = vehicleTypes.get(getRandomNumberInRange(0, vehicleTypes.size() - 1));
      Thread.sleep(getRandomNumberInRange(1, 3) * 1000L);
      eventCollector.add(new VehicleEvent(randomVehicleType));
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public int getRandomNumberInRange(int lower, int upper) {
    if (lower > upper) {
      throw new IllegalArgumentException("Upper bound must be greater than lower bound");
    }

    return new Random().nextInt(upper - lower + 1) + lower;
  }

  private BufferedReader setupSocketReader(int port) {
    try {
      Socket socket = new Socket("localhost", port);
      InputStream input = socket.getInputStream();
      return new BufferedReader(new InputStreamReader(input));
    } catch (UnknownHostException e) {
      e.printStackTrace();
      System.exit(0);
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(0);
    }
    return null;
  }
}
