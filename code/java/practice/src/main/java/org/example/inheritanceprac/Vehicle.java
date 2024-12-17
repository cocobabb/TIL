package org.example.inheritanceprac;

public class Vehicle {
    private String modelName;
    private int speed;
    private int fuelAmount;
    private static final int MAX_FUEL_AMOUNT = 100;

    public Vehicle(String modelName) {
        this.modelName = modelName;
        this.speed = 0;
        this.fuelAmount = 0;
    }


    public void addFuel(int fuelAmount){
        if(validateFuelAmount(fuelAmount)){
            this.fuelAmount+=fuelAmount;

            if(this.fuelAmount>getMaxFuelAmount()){
                this.fuelAmount = getMaxFuelAmount();
            }
        }else{
            System.out.println("Fail! check fuel amount");
        }
    }

    public boolean validateFuelAmount(int fuelAmount){
        if(this.fuelAmount != getMaxFuelAmount() && fuelAmount <= getMaxFuelAmount()){
            return true;
        }else{
            return false;
        }
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public int getMaxFuelAmount() {
        return MAX_FUEL_AMOUNT;
    }

    public int getSpeed() {
        return speed;
    }
    public void increaseSpeed(int speed){
        this.speed += speed;
    }

}
