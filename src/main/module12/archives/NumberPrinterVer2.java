package main.module12.archives;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NumberPrinterVer2 {

    private int number;
    private final Lock mutex = new ReentrantLock(false);

    private int count;

    public NumberPrinterVer2(int number) {
        this.number = number;
        count = 1;
    }

    public void fizzDemo () {
        Thread fizzThread = new Thread(() -> {
            try {
                this.fizz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        fizzThread.start();
    }

    public void buzzDemo () {
        Thread buzzThread = new Thread(() -> {
            try {
                this.buzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        buzzThread.start();
    }

    public void fizzBuzzDemo () {
        Thread fizzThread = new Thread(() -> {
            try {
                this.fizzBuzz();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        fizzThread.start();
        System.out.println("fizzThread Start");
    }

    public void numberDemo () {
        Thread numberThread = new Thread(() -> {
            try {
                this.number();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        numberThread.start();
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
                System.out.println("buzz");
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
                System.out.println("fizzBuzz");
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
                System.out.println(count);
                count++;
            }
            mutex.unlock();
        }
    }

    public static void main(String[] args) {

        NumberPrinterVer2 printer = new NumberPrinterVer2(15);
        printer.fizzDemo();
        printer.buzzDemo();
        printer.fizzBuzzDemo();
        printer.numberDemo();
    }
}
