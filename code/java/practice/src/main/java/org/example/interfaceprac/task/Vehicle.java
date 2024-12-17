package org.example.interfaceprac.task;

public abstract class Vehicle {
    public String vehicleValue = "vehicleValue";

    private String modelName;
    private int speed;
    private int fuelAmount;
    private static int maxFuelAmount = 100;

    public Vehicle(String modelName){
        this.modelName = modelName;
        this.speed = 0;
        this.fuelAmount = 0;
    }

    abstract void fuelMethod();
    abstract void speedMethod();

    public void vehicleMethod(){
        System.out.println("vehicle Method");
    }




}
