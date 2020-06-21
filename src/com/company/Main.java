package com.company;

import java.util.Scanner;

public class Main {
    public static boolean exit = true;
    public static String[] names = {
            "water",
            "milk",
            "coffee beans",
            "disposable cups",
            "money"
    };
    public static Integer[] amounts = {400, 540, 120, 9, 550};

    public static void print() {
        System.out.println("The coffee machine has:");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%d of %s%n", amounts[i], names[i]);
        }
    }

    public static void buyArr(Integer[] arr) {
        Integer[] tempArr = new Integer[5];
        boolean isPositive = true;
        String lack = "";

        for (int i = 0; i < amounts.length; i++) {
            tempArr[i] = amounts[i] - arr[i];
            if(tempArr[i] < 0) {
                lack = names[i];
                isPositive = false;
            }
        }

        if(isPositive) {
            for (int i = 0; i < amounts.length; i++) {
                amounts[i] -= arr[i];
            }
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            System.out.printf("Sorry, not enough %s!", lack);
        }
    }

    public static void buy() {
        Integer[] espresso = {250, 0, 16, 1, -4};
        Integer[] latte = {350, 75, 20, 1, -7};
        Integer[] cappuccino = {200, 100, 12, 1, -6};

        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte," +
                " 3 - cappuccino 4 - back: ");
        String op2 = scanner.nextLine();

        switch (op2) {
            case "1":
                buyArr(espresso);
                break;
            case "2":
                buyArr(latte);
                break;
            case "3":
                buyArr(cappuccino);
                break;
            case "back":
                option();
                break;
            default:
                break;
        }
    }

    public static void fill() {
        Scanner scanner = new Scanner(System.in);

        String format = "Write how many %s do you want to add: ";
        String[] n = {
                "ml of water",
                "ml of milk",
                "grams of coffee beans",
                "disposable cups of coffee"
        };

        for (int i = 0; i < amounts.length - 1; i++) {
            System.out.printf(format, n[i]);
            amounts[i] += scanner.nextInt();
        }

    }

    public static void take() {
        System.out.printf("I gave you $%d%n", amounts[4]);
        amounts[4] = 0;
    }

    public static void option() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write action (buy, fill, take, remaining, " +
                "exit): ");
        String op2 = scanner.next();

        switch (op2) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                print();
                break;
            case "exit":
                exit = false;
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        while (exit) {
            option();
        }
    }
}