package main.module12;

import java.util.ArrayList;
import java.util.List;

public class Proba {

    private int number;
    private List<Integer> list;

    public Proba (int number, List<Integer> list) {
        this.number = number;
        this.list = list;
    }

    public void printDigits () {
        for (int i = 0; i <= number; i++) {
            list.add(i);
            System.out.println("i = " + i);
        }
    }

    public static void main(String[] args) {
        List<Integer> digits = new ArrayList<>();
        new Proba(15, digits).printDigits();
    }


}
