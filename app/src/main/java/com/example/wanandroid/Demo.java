package com.example.wanandroid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Demo {
    private static ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        calculate();
        while (true) {
            String next = scanner.next();
            strings.add(next);

        }
    }

    private static void calculate() {
        for (; ; ) {
            if (!check(strings)) {
                return;
            }
        }
    }

    private static boolean check(ArrayList<String> strings) {
        String next = strings.iterator().next();
        if (next.equals("null")) {
            return false;
        }
        System.out.println(next);
        return true;
    }
}
