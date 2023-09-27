package main.module12.task2;

import main.module12.example.ProcessThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NumberReadPrintTests {

    public static void main(String[] args) {


/*        NumberPrinterVer2 printerVer2 = new NumberPrinterVer2(15);

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        try {
            executorService.execute(printerVer2.fizz(() -> System.out.println("fizz")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/




       List<NumberPrinter> threads = new ArrayList<>();

        NumberPrinter fizz = new NumberPrinter((n) -> {
            if (n % 3 == 0) {
                System.out.println("fizz");
            }
        });

        NumberPrinter buzz = new NumberPrinter((n) -> {
            if (n % 5 == 0) {
                System.out.println("buzz");
            }
        });

        NumberPrinter fizzBuzz = new NumberPrinter((n) -> {
            if (n % 5 == 0 && n % 3 == 0) {
                System.out.println("FizzBuzz");
            }
        });

        NumberPrinter number = new NumberPrinter(n -> {
            if (n % 5 != 0 && n % 3 != 0) {
                System.out.println(n);
            }
        });

        threads.add(fizz);
        threads.add(buzz);
        threads.add(fizzBuzz);
        threads.add(number);

        for (NumberPrinter thread : threads) {
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread.process(15);
        }

        for (NumberPrinter thread : threads) {
            thread.start();
        }
    }
}