package main.module12.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class NumberReadPrintTests {

    public static void main(String[] args) {

        BlockingQueue<Integer> digits = new SynchronousQueue<>();

        NumberReader numberReader = new NumberReader(digits, 15);

        new Thread(numberReader).start();
    }
}