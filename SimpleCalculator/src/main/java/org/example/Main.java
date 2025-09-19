package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            while(true) {
                Scanner sc = new Scanner(System.in);

                System.out.println("a | Addition");
                System.out.println("s | Subtraction");
                System.out.println("m | Multiplication");
                System.out.println("d | Division");
                System.out.println();

                String sInput = sc.nextLine();

                System.out.println("Enter first number");

                double dNum1 = Double.parseDouble(sc.nextLine());

                System.out.println("Enter second number");

                double dNum2 = Double.parseDouble(sc.nextLine());

                double dResult = switch (sInput) {
                    case "a" -> Calculator.add(dNum1, dNum2);
                    case "s" -> Calculator.subtract(dNum1, dNum2);
                    case "m" -> Calculator.multiply(dNum1, dNum2);
                    case "d" -> Calculator.divide(dNum1, dNum2);
                    default -> 0;
                };

                System.out.println(dResult);
            }
    }
}