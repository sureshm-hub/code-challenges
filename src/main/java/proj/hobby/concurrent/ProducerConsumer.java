package proj.hobby.concurrent;

import java.util.concurrent.*;

/**
 * implement Producer/Consumer problem using Blocking Queue
 *
 *
 *
 */
public class ProducerConsumer {

    private static final int QUEUE_SIZE = 10;
    private static BlockingQueue<Message> queue = new LinkedBlockingQueue<>(QUEUE_SIZE);

    public static void main(String[] args) {
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
		 this.queue = queue;
    }

    public void run() {
        try {
            while(true) {
                Message message = new Message("message: "+System.currentTimeMillis());
                queue.put(message);
                System.out.println("Produced "+message.getMessage());
                Thread.sleep(50); // simulate work
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Consumer implements Runnable {

    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> queue) {
		this.queue = queue;
    }

    public void run() {
        try {
            while(true) {
                Message message = queue.take();
                System.out.println("Consumed "+message.getMessage());
                Thread.sleep(75);// simulate work
            }
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Message {
    String message;
    public Message(String message) {
        this.message = message;
    }

    String getMessage() {
        return message;
    }
}