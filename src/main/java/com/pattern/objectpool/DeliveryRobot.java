package com.pattern.objectpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DeliveryRobot implements Robot {

  private static final Logger logger = LogManager.getLogger(DeliveryRobot.class);
  private static final AtomicInteger counter = new AtomicInteger(1);
  private final List<String> orderList;
  private final String name;

  public DeliveryRobot(String name) {
    this.name = name + counter.getAndIncrement();
    this.orderList = new ArrayList<>();
    logger.info("Robot '{}' initialized", this.name);
  }

  @Override
  public void reset() {
    logger.info("Order list reset");
    orderList.clear();
  }

  @Override
  public void takeOrder(String orderNo) {
    logger.info("Robot {} took the order: {}", this.name, orderNo);
    orderList.add(orderNo);
  }

  @Override
  public String getRobotName() {
    return name;
  }

  @Override
  public void printOrder() {
    logger.info("Robot {} - orderList: {}", this.name, orderList);
  }
}
