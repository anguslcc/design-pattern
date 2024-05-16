package com.pattern.objectpool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ObjectPool<T extends Poolable> {

  private static final Logger logger = LogManager.getLogger(ObjectPool.class);

  private final BlockingDeque<T> pool;

  public ObjectPool(Supplier<T> objectSupplier, int size) {
    logger.info("Initialize the Object Pool");
    pool = new LinkedBlockingDeque<>(size);
    for (int i = 0; i < size; i++) {
      if (!pool.offer(objectSupplier.get())) {
        throw new IllegalStateException("Could not add object to the pool.");
      }
    }
  }

  public T get() throws InterruptedException {
    logger.info("Get the object from the Object Pool");
    return pool.take();
  }

  public void release(T object) throws InterruptedException {
    logger.info("Put the object back to the Object Pool");
    object.reset();
    pool.put(object);
  }

}
