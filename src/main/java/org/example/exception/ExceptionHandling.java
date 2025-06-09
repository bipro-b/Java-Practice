package org.example.exception;

public class ExceptionHandling {

        public static void main(String[] args) {
            try {
                int[] numbers = {1, 2, 3};
                System.out.println(numbers[1]); // This will cause an ArrayIndexOutOfBoundsException
            } catch (Exception e) {
                System.out.println("Caught an ArrayIndexOutOfBoundsException: " + e.getMessage());
            } finally {
                System.out.println("This block always executes.");
            }

            System.out.println("Program continues after exception handling.");
        }

}
