package com.pattern.objectpool;

public interface Robot extends Poolable {

  void takeOrder(String orderNo);

  String getRobotName();

  void printOrder();
}
