package main.module12.task2;

public class NumberPrinter {

    public static void main(String[] args) {
        Task task = new Task(15);
        Thread firstThread = new Thread(new Control(task, 1), " Fizz");
        Thread secondThread = new Thread(new Control(task, 2), " Buzz");
        Thread thirdThread = new Thread(new Control(task, 3), " Fizz-Buzz");
        Thread fourthThread = new Thread(new Control(task, 4), " ");
        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
    }
}
