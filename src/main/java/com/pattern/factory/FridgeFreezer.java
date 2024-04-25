package com.pattern.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FridgeFreezer extends Appliance {

  private static final Logger logger = LogManager.getLogger(FridgeFreezer.class);

  private static final String DESCRIPTION = "I'm a fridge freezer";

  protected FridgeFreezer(String serialNumber) {
    super(serialNumber, DESCRIPTION);
  }

  @Override
  public void operate() {
    logger.info("Fridge freezer is started.");

  }
}
