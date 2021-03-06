package com.thinkinginjava.concurrency.booksource;//: concurrency/DaemonsDontRunFinally.java
// Daemon threads don't run the finally clause
import java.util.concurrent.*;
import static net.mindview.util.Print.*;

class ADaemon implements Runnable {
  public void run() {
    try {
      System.out.println("Starting ADaemon");
      TimeUnit.SECONDS.sleep(1);
    } catch(InterruptedException e) {
      System.out.println("Exiting via InterruptedException");
    } finally {
      System.out.println("This should always run?");
    }
  }
}

public class DaemonsDontRunFinally {
  public static void main(String[] args) throws Exception {
    Thread t = new Thread(new ADaemon());
    t.setDaemon(true);
    t.start();
  //  TimeUnit.SECONDS.sleep(1);
  }
} /* Output:
Starting ADaemon
*///:~
