package com.pattern.factorymethod;

public class GraduationCard extends Card {

  protected GraduationCard(String sender, String receiver) {
    super(sender, receiver);
  }

  @Override
  public String getMessage() {
    return "Congratulations on Your Graduation!!";
  }
}
