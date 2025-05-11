package org.example.oop.polymorphism;

public class Main {
    public static void main(String[] args) {
        Calculation sumCalculator = new Calculation();

        int sum1= sumCalculator.sum(23,45);
        System.out.println(sum1);

        int sum2 = sumCalculator.sum(34,45,67);
        System.out.println(sum2);

        double sum3 = sumCalculator.sum(56.78,45.89);
        System.out.println(sum3);

        Car car = new Car();
        car.start();

    }
}
