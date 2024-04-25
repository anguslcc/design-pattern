package com.pattern.factory;

import java.util.UUID;

public class ApplianceFactory {

  private ApplianceFactory() {
  }

  public static Appliance getAppliance(ApplianceType applianceType) {

    return switch (applianceType) {
      case FRIDGE_FREEZER -> new FridgeFreezer(generateSerialNumber());
      case MICROWAVE -> new Microwave(generateSerialNumber());
      case WASHING_MACHINE -> new WashingMachine(generateSerialNumber());
    };
  }

  private static String generateSerialNumber() {
    return UUID.randomUUID().toString();
  }

}
