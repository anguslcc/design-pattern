package com.pattern.adapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Staff {

  private final String firstName;
  private final String lastName;
  private final List<String> addressLineList;

  public Staff(String firstName, String lastName, List<String> addressLineList) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.addressLineList = new ArrayList<>(addressLineList);
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public List<String> getAddressLineList() {
    return Collections.unmodifiableList(addressLineList);
  }
}
