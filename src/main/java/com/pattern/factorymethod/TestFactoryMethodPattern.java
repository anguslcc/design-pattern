package com.pattern.factorymethod;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestFactoryMethodPattern {

  private static final Logger logger = LogManager.getLogger(TestFactoryMethodPattern.class);

  public static void main(String[] args) {
    List<Card> cardList = new ArrayList<>();
    CardFactory birthdayCardFactory = new BirthdayCardFactory();
    CardFactory graduationCardFactory = new GraduationCardFactory();

    cardList.add(birthdayCardFactory.assembleCard("Tom", "Mary"));
    cardList.add(graduationCardFactory.assembleCard("Sam", "John"));
    cardList.add(birthdayCardFactory.assembleCard("Fiona", "Sue"));
    cardList.add(graduationCardFactory.assembleCard("Peter", "Jerry"));

    for (int i = 0; i < cardList.size(); i++) {
      logger.info("Card #{}: {}", i, cardList.get(i));
    }

  }
}
