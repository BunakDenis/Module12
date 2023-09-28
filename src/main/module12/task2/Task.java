package main.module12.task2;

public class Task {

    private volatile int isTurn = 4;
    volatile int count = 1;
    private final int number;

    public Task (int number) {
        this.number = number;
    }

    public int getNumber () {
        return number;
    }

    public synchronized void printNum(int isTurn) {
        try {
            while (count <= number && this.isTurn != isTurn) {
                wait();
            }
            if (count <= number) {
                System.out.println(count + Thread.currentThread().getName());
                Thread.sleep(1000);
                this.isTurn = getNextTurn(count + 1);
                count++;
                notifyAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int getNextTurn(int number) {
        return number % 15 == 0 ? 3 : (number % 5 == 0 ? 2 : (number % 3 == 0 ? 1 : 4));
    }
}
