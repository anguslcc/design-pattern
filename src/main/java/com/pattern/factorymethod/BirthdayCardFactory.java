package com.pattern.factorymethod;

public class BirthdayCardFactory extends CardFactory {

  @Override
  protected Card getCard(String sender, String receiver) {
    return new BirthdayCard(sender, receiver);
  }
}
