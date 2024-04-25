package com.pattern.factory;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestFactoryPattern {

  private static final Logger logger = LogManager.getLogger(TestFactoryPattern.class);

  public static void main(String[] args) {
    List<Appliance> applianceList = new ArrayList<>();
    applianceList.add(ApplianceFactory.getAppliance(ApplianceType.FRIDGE_FREEZER));
    applianceList.add(ApplianceFactory.getAppliance(ApplianceType.MICROWAVE));
    applianceList.add(ApplianceFactory.getAppliance(ApplianceType.WASHING_MACHINE));

    for (Appliance appliance : applianceList) {
      logger.info("Appliance #{}", appliance.getSerialNumber());
      logger.info("Description: #{}", appliance.getDescription());
      appliance.operate();
    }

  }
}
