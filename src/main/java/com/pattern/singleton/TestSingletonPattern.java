package com.pattern.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestSingletonPattern {

  private static final Logger logger = LogManager.getLogger(TestSingletonPattern.class);

  public static void main(String[] args) {
    logger.info("Start to instantiate EagerInitializedSingleton");
    logger.info("Value in EagerInitializedSingleton: {}",
        EagerInitializedSingleton.getInstance().getValue());

    logger.info("Start to instantiate LazyInitializedSingleton");
    logger.info("Value in LazyInitializedSingleton: {}",
        LazyInitializedSingleton.getInstance().getValue());

  }
}
