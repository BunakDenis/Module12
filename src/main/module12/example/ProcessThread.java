package main.module12.example;

import java.util.concurrent.atomic.AtomicBoolean;

public class ProcessThread extends Thread {

    private int number;
    private AtomicBoolean processed = new AtomicBoolean(true);
    private NumberProcessor processor;

    public ProcessThread(NumberProcessor processor) {
        this.processor = processor;
    }

       public boolean isProcessed () {
        return processed.get();
       }
    public synchronized void process(int number) {
        this.number = number;
        processed.set(false);
    }

    @Override
    public void run() {
        while (true) {
            if (processed.get()) {
                continue;
            }

            processor.process(number);

        }
    }
}
