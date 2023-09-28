package main.module12.archives;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FizzDemo {

    private final Lock mutex = new ReentrantLock(true);
    private int number;
    private int count;

    public FizzDemo (int number) {
        this.number = number;
        count = 1;
    }

    public void demo () {

        Thread thread = new Thread(this::fizz);
        thread.start();

    }

    private void fizz () {
        while (true) {

            if (count <= number) {

                return;
            }
            if (count % 3 == 0) {
                count++;
                System.out.println("fizz");
            }

        }
    }

    public static void main(String[] args) {
        FizzDemo fizzDemo = new FizzDemo(15);
        fizzDemo.demo();
    }
}