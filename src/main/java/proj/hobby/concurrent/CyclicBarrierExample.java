package proj.hobby.concurrent;

import java.util.concurrent.*;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier( 3 , () -> System.out.println("All threads finished stage"));

        for(int i =0 ; i < 3; i++) {
            new DataProcessor(barrier, "Proc"+i).start();
        }
    }


}

class DataProcessor extends Thread {

    private final CyclicBarrier barrier;
    private final String name;

    public DataProcessor(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    public void run() {
        try {
            System.out.println(name+" DataProcessor Thread Started");

            Thread.sleep((int)(Math.random() * 500)); // perform stage 1 -  simulate action
            System.out.println(name+" Thread completed stage 1");

            barrier.await(); // let other threads catchup

            Thread.sleep((int)(Math.random() * 300)); // perform stage 2 - simulate action
            System.out.println(name+" Thread completed stage 2");
            barrier.await(); // let other threads catchup

            System.out.println(name+" DataProcessor Thread Finished!!");
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
