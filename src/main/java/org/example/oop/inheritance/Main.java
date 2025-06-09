package org.example.oop.inheritance;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.setDoors(4);
        vehicle.setWheels(4);
        vehicle.setColor("Red");

        Car car  = new Car();
        car.setModel("Toyota");
        car.setEngine("V6");
//        car.setDoors(4);
//        car.setWheels(4);
//        car.setColor("Blue");

        System.out.println("Vehicle: " + vehicle.getColor() + ", Doors: " + vehicle.getDoors() + ", Wheels: " + vehicle.getWheels());

    }

}
