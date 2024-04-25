package com.pattern.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WashingMachine extends Appliance {

  private static final Logger logger = LogManager.getLogger(WashingMachine.class);

  private static final String DESCRIPTION = "I'm a washing machine";

  protected WashingMachine(String serialNumber) {
    super(serialNumber, DESCRIPTION);
  }

  @Override
  public void operate() {
    logger.info("Washing machine is started.");

  }
}
