package org.example.oop.polymorphism;

public class Calculation {

    // Method Overloading : Name of method is similar but parameters are different
    public int sum(int a,int b){
        System.out.println("Method with 2 int parameters");
        int sum = a+b;
        return sum;
    }
    public int sum(int a,int b,int c){
        System.out.println("Method with 3 int parameters");
        int sum = a+b+c;
        return sum;
    }
    public double sum(double a, double b){
        System.out.println("Method with 2 double parameters");
        double sum = a+b;
        return sum;
    }
}
