package org.example.exception;

public class A {

    public static void main(String[] args) {
        {
            int n = 10;
            int m = 0;

            try {

                // Code that may throw an exception
                int ans = n / m;
                System.out.println("Answer: " + ans);
            } catch (Exception e) {
                // Handling the exception
                System.out.println("Error: Division by zero is not allowed!");
            } finally {
                System.out.println("Program continues after handling the exception.");
            }
        }
    }

}


//public static void main(String[] args)

//}