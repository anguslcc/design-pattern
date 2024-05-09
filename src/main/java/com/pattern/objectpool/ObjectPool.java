package com.pattern.objectpool;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.function.Supplier;

public class ObjectPool<T extends Poolable> {

  private final BlockingDeque<T> pool;

  public ObjectPool(Supplier<T> objectSupplier, int size) {
    pool = new LinkedBlockingDeque<>(size);
    for (int i = 0; i < size; i++) {
      if (pool.offer(objectSupplier.get())) {
        throw new IllegalStateException("Could not add object to the pool.");
      }
    }
  }

  public T get() throws InterruptedException {
    return pool.take();
  }

  public void release(T object) throws InterruptedException {
    object.reset();
    pool.put(object);
  }

}
