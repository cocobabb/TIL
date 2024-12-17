package org.example.interfaceprac.task;

public class Bus extends Vehicle implements Passengerable {
    private static int maxFuelAmount = 300;
    public String busValue = "busValue";
    public Bus(String modelName) {
        super(modelName);
    }
// 추상클래스에서 오버라이딩
    @Override
    void fuelMethod() {
        System.out.println("Bus: [abstract class] fuel Method");
    }
//  추상클래스에서 오버라이딩
    @Override
    void speedMethod() {
        System.out.println("Bus: [abstract class] speed Method");
    }

//  인터페이스에서 오버라이딩
    @Override
    public void passengerMethod() {
        System.out.println("Bus: [interface] passenger Method");
    }
}
