package com.pattern.builder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestBuilderPattern {

  private static final Logger logger = Logger.getLogger(TestBuilderPattern.class.getName());

  public static void main(String[] args) {
    User user = new User.UserBuilder("Tom", "Chan")
        .withAge(25).withIncome(30000)
        .build();

    logger.log(Level.INFO, "User: {0}", user);
  }
}
