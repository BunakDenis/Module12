package main.module12.example;

import java.util.ArrayList;
import java.util.List;

public class NumberThreadTests {

    public static void main(String[] args) {
            ProcessThread fizzBuzz = new ProcessThread((n) -> {
                if (n % 3 == 0 && n % 5 == 0){
                    System.out.println("FizzBuzz");
                }
            });

        ProcessThread buzz = new ProcessThread((n) -> {
            if (n % 5 == 0){
                System.out.println("Buzz");
            }
        });

        ProcessThread fizz = new ProcessThread((n) -> {
            if (n % 3 == 0){
                System.out.println("Fizz");
            }
        });

        ProcessThread number = new ProcessThread((n) -> {
            if (n % 3 != 0 && n % 5 != 0){
                System.out.println(n);
            }
        });

        List<ProcessThread> threads = new ArrayList<>();

        threads.add(fizzBuzz);
        threads.add(buzz);
        threads.add(fizz);
        threads.add(number);

        for (ProcessThread thread : threads) {
            thread.start();
        }

        for (int i = 0; i < 10; i++) {
            for (ProcessThread thread : threads) {
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                thread.process(i);
            }

            while (true) {
                int processedCount = 0;
                for (ProcessThread thread : threads) {
                    if (thread.isProcessed()) {
                        processedCount++;
                    }
                }

                if (processedCount == threads.size()) {
                    break;
                }

            }

        }
    }
}
