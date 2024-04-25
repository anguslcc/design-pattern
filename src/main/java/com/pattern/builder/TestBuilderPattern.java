package com.pattern.builder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestBuilderPattern {

  private static final Logger logger = LogManager.getLogger(TestBuilderPattern.class);

  public static void main(String[] args) {
    User user = new User.UserBuilder("Tom", "Chan")
        .withAge(25).withIncome(30000)
        .build();

    logger.info("User: {}", user);
  }
}
