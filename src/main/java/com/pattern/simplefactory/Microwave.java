package com.pattern.simplefactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Microwave extends Appliance {

  private static final Logger logger = LogManager.getLogger(Microwave.class);

  private static final String DESCRIPTION = "I'm a microwave";

  protected Microwave(String serialNumber) {
    super(serialNumber, DESCRIPTION);
  }

  @Override
  public void operate() {
    logger.info("Microwave is started.");

  }
}
