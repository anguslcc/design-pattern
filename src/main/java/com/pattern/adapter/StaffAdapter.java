package com.pattern.adapter;

public class StaffAdapter implements Recipient {

  private final Staff staff;

  public StaffAdapter(Staff staff) {
    this.staff = staff;
  }


  @Override
  public String getName() {
    return String.format("%s %s", staff.getFirstName(), staff.getLastName());
  }

  @Override
  public String getAddress() {
    return String.join("\n", staff.getAddressLineList());
  }
}
