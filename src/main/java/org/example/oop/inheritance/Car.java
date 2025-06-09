package org.example.oop.inheritance;

import org.example.oop.polymorphism.Vehicle;

public class Car extends Vehicle {
    private String model;
    private String engine;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }
}
