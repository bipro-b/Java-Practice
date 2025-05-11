package org.example.oop;




public class Teststudent {

    public static void main(String[] args) {
        Student bipro = new Student();
        Student trisha = new Student();


        Student.test();;


        bipro.setId(1);
        bipro.setName("John Doe");
        bipro.setScore(1, 85);
        bipro.setScore(2, 90);
        bipro.setScore(3, 78);


        trisha.setId(2);
        trisha.setName("Jane Smith");
        trisha.setScore(1, 88);
        trisha.setScore(2, 92);
        trisha.setScore(3, 80);

        double result = bipro.calcAverage();

        System.out.println(result);

        for(int i=1; i<=3; i++){
            System.out.println(bipro.getScore(i));
        }

        if(bipro.equals(trisha)) {
            System.out.println("Both students are equal");
        }
        else {
            System.out.println("Both students are not equal");
        }


    }



}
