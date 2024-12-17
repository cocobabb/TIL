package org.example.interfaceprac.task;

public class Truck extends Vehicle implements Luggagable {
    private static int maxFuelAmount = 250;

    public Truck(String modelName) {
        super(modelName);
    }
    // 추상클래스에서 오버라이딩
    @Override
    void fuelMethod() {
        System.out.println("Truck: [abstract class] fuel Method");
    }
    // 추상클래스에서 오버라이딩
    @Override
    void speedMethod() {
        System.out.println("Truck: [abstract class] speed Method");
    }

//    인터페이스에서 오버라이딩
    @Override
    public void luggageMethod() {
        System.out.println("Truck: [interface] luggage Method");
    }
}
