package main.module12.task2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class NumberPrinterVer2 {

    private int number;
    private final Lock mutex = new ReentrantLock(true);

    private int count;

    public NumberPrinterVer2(int number) {
        this.number = number;
        count = 1;
    }

    public synchronized void fizz() throws InterruptedException {
        while (true) {
            mutex.lock();
            if (count <= number) {
                mutex.unlock();
                return;
            }
            if (count % 3 == 0) {
                count++;
                System.out.println("fizz");
                ;
            }
            mutex.unlock();
        }
    }

    public synchronized void buzz() throws InterruptedException {
        while (true) {
            mutex.lock();
            if (count <= number) {
                mutex.unlock();
                return;
            }
            if (count % 5 == 0) {
                count++;
            }
            mutex.unlock();
        }
    }

    public synchronized void fizzBuzz() throws InterruptedException {
        while (true) {
            mutex.lock();
            if (count <= number) {
                mutex.unlock();
                return;
            }
            if (count % 5 == 0 && count % 3 == 0) {
                count++;
            }
            mutex.unlock();
        }
    }

    public synchronized void number() throws InterruptedException {
        while (true) {
            mutex.lock();
            if (count <= number) {
                mutex.unlock();
                return;
            }
            if (count % 5 != 0 && count % 3 != 0) {
                count++;
            }
            mutex.unlock();
        }
    }

    public static void main(String[] args) {


        NumberPrinterVer2 printer = new NumberPrinterVer2(15);

        new Thread(() -> {
            while (true) {
                try {
                    printer.fizz();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    printer.buzz();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    printer.fizzBuzz();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    printer.number();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
