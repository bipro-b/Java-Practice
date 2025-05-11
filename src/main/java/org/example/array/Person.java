package org.example.array;

public class Person {
    public static void main(String[] args) {


//       // int [] personAge = new int[];

        int[] personAge = {23, 45, 67, 89, 12, 34, 56, 78, 90, 11,
                22, 33, 44, 55, 66, 77, 88, 99, 100, 101,
                102, 103, 104, 105, 106, 107, 108, 109, 110,
                111, 112, 113, 114, 115, 116, 117, 118, 119,
                120};

        System.out.println(personAge[0]);
        int l = personAge.length;
        System.out.println(l);

        int sum = 0;

        for (int i = 0; i < l; i++) {
            sum += personAge[i];
        }

        double average = (double) sum / l;
        System.out.println("Average: " + average);

        String[] personName = new String[5];
        personName[0] = "John";
        personName[1] = "Doe";
        personName[2] = "Jane";
        personName[3] = "Smith";
        personName[4] = "Alice";
        System.out.println(personName[0]);

        for (String name : personName) {
            System.out.println(name);
        }

        String[] personName2 = {"John", "Doe", "Jane", "Smith", "Alice"};

        System.out.println(personName2[0]);


        int [] a = new int[] {1,2,3,4,5,6,7,8,9,10};

        int [][] b = new int[3][3];
        b[0][0] = 1;
        b[0][1] = 2;
        b[0][2] = 3;
        b[1][0] = 4;
        b[1][1] = 5;
        b[1][2] = 6;
        b[2][0] = 7;
        b[2][1] = 8;
        b[2][2] = 9;

        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){
                System.out.println(b[i][j]);
            }
        }





        // Array Vs ArrayList




    }
}
