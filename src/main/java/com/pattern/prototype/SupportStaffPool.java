package com.pattern.prototype;

import java.util.ArrayList;
import java.util.List;

public class SupportStaffPool {

  private final List<String> staffList;

  public SupportStaffPool(List<String> staffList) {
    this.staffList = new ArrayList<>(staffList);
  }

  public void addStaff(String staff) {
    this.staffList.add(staff);
  }

  public List<String> getStaffList() {
    return new ArrayList<>(staffList);
  }

  public static SupportStaffPool newInstance(SupportStaffPool otherSupportStaffPool) {
    return new SupportStaffPool(otherSupportStaffPool.getStaffList());
  }

  @Override
  public String toString() {
    return "SupportStaffPool{" +
        "staffList=" + staffList +
        '}';
  }
}
