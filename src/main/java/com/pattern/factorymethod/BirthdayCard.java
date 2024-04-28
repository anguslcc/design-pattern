package com.pattern.factorymethod;

public class BirthdayCard extends Card {

  protected BirthdayCard(String sender, String receiver) {
    super(sender, receiver);
  }

  @Override
  public String getMessage() {
    return "Happy Birthday!!";
  }

}
