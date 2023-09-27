package main.module12.task1;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicLong;

public class TimeShower {

    public static void main(String[] args) {
        AtomicLong secondsFromStartMain = new AtomicLong(System.currentTimeMillis());
        AtomicLong secondsLast = new AtomicLong(System.currentTimeMillis());


        Thread secondLeftFromStartThread = new Thread(() -> {

            while (true) {

                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Время - " + ((System.currentTimeMillis() - secondsFromStartMain.get()) / 1000 ));

            }
        });

        Thread everyFiveSecondsShowThread = new Thread(() -> {

            while (true) {

                if (((System.currentTimeMillis() - secondsLast.get()) / 1000) == 5) {
                    System.out.println("Прошло 5 секунд");
                    secondsLast.set(System.currentTimeMillis());
                }
            }
        });

        secondLeftFromStartThread.start();
        everyFiveSecondsShowThread.start();

    }
}
