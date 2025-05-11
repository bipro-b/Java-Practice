package org.example.oop;

public class Student {
    private int id;
    private String name;
    private int test1;
    private int test2;
    private int test3;

    private static double CGPA;

    public static void test(){
        CGPA = 3.5;

        System.out.println("Static method called");
//        calcAverage();
    }

    public Student() {

        System.out.println("Default constructor called");
        id =0;
        name="";
        test1=0;
        test2=0;
        test3=0;
    }

//    public Student(int id, String name, int test1, int test2, int test3) {
//        System.out.println("Parameterized constructor called");
//        this.id = id;
//        this.name = name;
//        this.test1 = test1;
//        this.test2 = test2;
//        this.test3 = test3;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setScore(int i,int score){
        if(i==1){
            test1=score;
        }else if(i==2){
            test2=score;
        }else if(i==3){
            test3=score;
        }else{
            System.out.println("Invalid test number");
        }
    }

    public int getScore (int i){
        if(i==1){
            return test1;
        }else if(i==2){
            return test2;
        }else if(i==3){
            return test3;
        }else{
            System.out.println("Invalid test number");
            return -1;
        }
    }

    public double calcAverage(){
        CGPA=4.0;
        test();
        System.out.println("Calculating average");
        double average = (test1+test2+test3)/3.0;
        return average;
    }
}
