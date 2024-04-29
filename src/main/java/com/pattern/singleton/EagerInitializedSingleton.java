package com.pattern.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EagerInitializedSingleton {

  private static final Logger logger = LogManager.getLogger(EagerInitializedSingleton.class);

  private final int value;

  private static final EagerInitializedSingleton instance;

  static {
    instance = new EagerInitializedSingleton();
  }

  private EagerInitializedSingleton() {
    value = 100;
    logger.info("EagerInitializedSingleton initialized");
  }

  public static EagerInitializedSingleton getInstance() {
    return instance;
  }

  public int getValue() {
    return value;
  }
}
