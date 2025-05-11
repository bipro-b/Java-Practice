package org.example.oop;

public class Main {
    public static void main(String[] args) {

        // vehicle1 is an object of the Vehicle class
        Vehicle vehicle1 = new Vehicle();

        vehicle1.setDoors(4);
        vehicle1.setWheels(4);
        vehicle1.setWindows(6);
        vehicle1.setColor("Red");
        vehicle1.setElectric(true);
        System.out.println("Vehicle 1:");
        vehicle1.displyVehicleInfo();


        // vehicle2 is an object of the Vehicle class
        Vehicle vehicle2 = new Vehicle();
        vehicle2.setDoors(2);
        vehicle2.setWheels(4);
        vehicle2.setWindows(4);
        vehicle2.setColor("Blue");
        vehicle2.setElectric(false);
        System.out.println("Vehicle 2:");
        vehicle2.displyVehicleInfo();
    }
}
