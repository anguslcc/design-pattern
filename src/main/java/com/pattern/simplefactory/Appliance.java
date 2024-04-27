package com.pattern.simplefactory;

public abstract class Appliance {

  private final String serialNumber;
  private final String description;

  protected Appliance(String serialNumber, String description) {
    this.serialNumber = serialNumber;
    this.description = description;
  }

  public abstract void operate();

  public String getSerialNumber() {
    return serialNumber;
  }

  public String getDescription() {
    return description;
  }
}
