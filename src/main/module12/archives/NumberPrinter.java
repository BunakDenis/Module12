package main.module12.archives;

import java.util.concurrent.atomic.AtomicBoolean;

public class NumberPrinter extends Thread {
    private int number;

    private final NumberProcessor processor;

    AtomicBoolean flag = new AtomicBoolean(false);

    public NumberPrinter(NumberProcessor processor) {
        this.processor = processor;
    }

    public void process(int number) {
        this.number = number;
        flag.set(true);
    }

    @Override
    public void run() {
        while (flag.get()) {

            for (int i = 0; i <= number; i++) {
                try {
                    Thread.sleep(250l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                processor.process(i);

                if (i == number) {
                    flag.set(false);
                }
            }
        }
    }
}
