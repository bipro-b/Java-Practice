package org.example.oop;

public class Vehicle {
    private int doors;
    private int wheels;
    private int windows;
    private String color;
    private boolean isElectric;





    public int getDoors(){
        return doors;
    }

    public void setDoors(int doors){
        this.doors = doors;
    }

    public int getWheels(){
        return wheels;
    }

    public void setWheels(int wheels){
        this.wheels = wheels;
    }

    public int getWindows() {
        return windows;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public void setElectric(boolean electric) {
        isElectric = electric;
    }


    @Override
    public String toString() {


        return super.toString();
    }

    public void displyVehicleInfo() {
        System.out.println("Vehicle Info:");
        System.out.println("Doors: " + doors);
        System.out.println("Wheels: " + wheels);
        System.out.println("Windows: " + windows);
        System.out.println("Color: " + color);
        System.out.println("Electric: " + isElectric);
    }
}
