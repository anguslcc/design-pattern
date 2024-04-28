package com.pattern.prototype;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestPrototypePattern {

  private static final Logger logger = LogManager.getLogger(TestPrototypePattern.class);

  public static void main(String[] args) {
    SupportStaffPool supportStaffPool1 = new SupportStaffPool(List.of("Tom", "Ann", "Mary"));

    SupportStaffPool supportStaffPool2 = SupportStaffPool.newInstance(supportStaffPool1);

    supportStaffPool2.addStaff("John");

    logger.info("supportStaffPool1: {}", supportStaffPool1);
    logger.info("supportStaffPool2: {}", supportStaffPool2);


  }

}
