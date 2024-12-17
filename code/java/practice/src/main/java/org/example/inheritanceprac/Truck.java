package org.example.inheritanceprac;

public class Truck extends Vehicle{
    int luggageWeight;
    public static final int MAX_FUEL_AMOUNT = 250;


    public Truck(String modelName) {
        super(modelName);
        this.luggageWeight = 0;
    }

    public void addLuggageWeight(int luggageWeight){
        this.luggageWeight += luggageWeight;
    }
    public int getLuggageWeight() {
        return luggageWeight;
    }

    @Override
    public int getMaxFuelAmount() {
        return MAX_FUEL_AMOUNT;
    }


}
