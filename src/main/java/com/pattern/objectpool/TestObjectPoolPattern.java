package com.pattern.objectpool;

public class TestObjectPoolPattern {

  private static final ObjectPool<Robot> robotPool = new ObjectPool<>(
      () -> new DeliveryRobot("Roo"), 10);

  public static void main(String[] args) throws InterruptedException {
    Robot r1 = robotPool.get();
    Robot r2 = robotPool.get();

    r1.takeOrder("Order A");
    r1.takeOrder("Order B");
    r1.printOrder();

    r2.takeOrder("Order C");
    r2.takeOrder("Order D");
    r2.printOrder();

    robotPool.release(r1);
    robotPool.release(r2);

    r1.printOrder();
    r2.printOrder();


  }
}
