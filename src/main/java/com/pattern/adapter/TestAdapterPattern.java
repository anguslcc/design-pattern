package com.pattern.adapter;

import java.util.Arrays;

public class TestAdapterPattern {

  public static void main(String[] args) {
    Staff staff = new Staff(
        "Tom",
        "Cat",
        Arrays.asList("34 Witch Road", "Oxford", "United Kingdom"));

    StaffAdapter staffAdapter = new StaffAdapter(staff);

    EnvelopeCreator envelopeCreator = new EnvelopeCreator(staffAdapter);

    envelopeCreator.printRecipient();

  }

}
