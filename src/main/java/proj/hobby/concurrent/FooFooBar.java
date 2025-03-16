package proj.hobby.concurrent;

import java.util.concurrent.*;

/**
 *  A Twist on FooBar to print FooFooBar -  https://leetcode.com/problems/print-foobar-alternately/
 *
 * Approach: Use Semaphore to synchronize Foo & Bar
 *
 *
 */
public class FooFooBar {
    private int n;
    private Semaphore fooSemaphore = new Semaphore(2); // allow foo first
    private Semaphore barSemaphore = new Semaphore(0); // hold bar till foo runs


    public FooFooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire(); // ensure foo runs first
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fooSemaphore.acquire();  // acquire again for printing Foo second time
            printFoo.run();
            barSemaphore.release(); // now we can  allow bar to run
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire(); // ensure bar is allowed to run
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSemaphore.release(2); // release foo to print twice
        }
    }


    public static void main(String[] args) {
        FooFooBar foofoobar = new FooFooBar(3);

        Runnable printFoo = () -> System.out.print("Foo");
        Runnable printBar = () -> System.out.print("Bar");

        Thread t1 = new Thread(){
            public void run() {
                try {
                    foofoobar.foo(printFoo);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread(){
            public void run() {
                try {
                    foofoobar.bar(printBar);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };

        t1.start();
        t2.start();
    }
}
