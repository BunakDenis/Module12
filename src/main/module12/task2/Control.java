package main.module12.task2;

public class Control implements Runnable {

    Task task;
    int isTurn;

    public Control(Task task, int isTurn) {
        this.task = task;
        this.isTurn = isTurn;
    }

    @Override
    public void run() {
        while (task.count <= task.getNumber()) {
            task.printNum(isTurn);
        }
    }
}
