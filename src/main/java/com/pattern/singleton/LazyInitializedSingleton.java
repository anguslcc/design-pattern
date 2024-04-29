package com.pattern.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LazyInitializedSingleton {

  private static final Logger logger = LogManager.getLogger(LazyInitializedSingleton.class);
  private final int value;

  private LazyInitializedSingleton() {
    this.value = 150;
    logger.info("LazyInitializedSingleton initialized");
  }

  public static LazyInitializedSingleton getInstance() {
    return SingletonHelper.INSTANCE;
  }

  private static class SingletonHelper {

    private static final LazyInitializedSingleton INSTANCE = new LazyInitializedSingleton();
  }

  public int getValue() {
    return value;
  }
}
