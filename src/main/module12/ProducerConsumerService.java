package main.module12;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerService {

    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Example2 producer = new Example2 (queue);
        //starting producer to produce messages in queue
        new Thread(producer).start();
        System.out.println("Producer and Consumer has been started");
    }

}
