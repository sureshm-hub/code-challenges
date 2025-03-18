package proj.hobby.concurrent;

import java.util.concurrent.*;

public class CountDownLatchExample {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        new Service(latch, "DB Service").start();
        new Service(latch, "Account Service").start();
        new Service(latch, "Payment Service").start();

        try {
            latch.await();
            System.out.println("All three services started");
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        // perform application actions
    }
}


class Service extends Thread {

    private final CountDownLatch latch;
    private final String serviceName;

    public Service(CountDownLatch latch, String serviceName){
        this.latch = latch;
        this.serviceName = serviceName;
    }

    public void run() {
        try{
            System.out.println(serviceName+" Service is initializing ...");
            Thread.sleep((int) (Math.random() * 3000));// simulate startup action
            System.out.println(serviceName+" Service is up & running!" );
            latch.countDown();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}