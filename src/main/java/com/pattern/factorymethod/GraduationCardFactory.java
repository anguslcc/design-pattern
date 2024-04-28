package com.pattern.factorymethod;

public class GraduationCardFactory extends CardFactory {

  @Override
  protected Card getCard(String sender, String receiver) {
    return new GraduationCard(sender, receiver);
  }
}
