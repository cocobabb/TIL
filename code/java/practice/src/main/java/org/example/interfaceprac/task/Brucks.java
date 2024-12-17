package org.example.interfaceprac.task;

public class Brucks extends Vehicle implements Passengerable, Luggagable {
    private static int maxFuelAmount = 1000;

    public Brucks(String modelName) {
        super(modelName);
    }

    // 추상클래스에서 오버라이딩
    @Override
    void fuelMethod() {
        System.out.println("Brucks: [abstract class] fuel Method");
    }
    // 추상클래스에서 오버라이딩
    @Override
    void speedMethod() {
        System.out.println("Brucks: [abstract class] speed Method");
    }
//    인터페이스에서 오버라이딩
    @Override
    public void luggageMethod() {
        System.out.println("Brucks: [interface] luggage Method");
    }
//    인터페이스에서 오버라이딩
    @Override
    public void passengerMethod() {
        System.out.println("Brucks: [interface] passenger Method");
    }
}
