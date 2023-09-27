package main.module12.task2;

import java.util.concurrent.BlockingQueue;

public class NumberReader extends Thread {

    private int number;

    private BlockingQueue<Integer> digits;

    public NumberReader(BlockingQueue<Integer> digits, int number) {
        this.number = number;
        this.digits = digits;
    }

    @Override
    public void run() {
        for (int i = 1; i <= this.number; i++) {
            Integer element = i;
            try {
                Thread.sleep(100l);
                digits.put(element);
                System.out.println("Put digit " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}