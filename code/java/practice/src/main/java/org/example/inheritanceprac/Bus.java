package org.example.inheritanceprac;

public class Bus extends Vehicle{
    private int passengerCount;
    public static final int MAX_FUEL_AMOUNT = 300;


    public Bus(String modelName, int passengerCount) {
        super(modelName);
        this.passengerCount = passengerCount;
    }

    public int addPassenger(int passengerCount){
        this.passengerCount += passengerCount;
        return passengerCount;
    }

//   에러 
//   => addFuel 메서드를 오버라이드 해서 이용 시 
//   해당 메서드는 그 클래스의 private 정적 필드(클래스 필드)를 사용하여 해당 메서드를 사용하기 때문에
//   오버라이드 된 메서드를 쓰는 경우 현재 정적필드가 적용이 되지않음

//   해결
//    => 현재 정적 필드가 적용될 수 있도록 상속하는 클래스의 addFuel 에서 쓰는
//    private 정적 필드(클래스 필드)를 getter를 이용하여 사용하고 
//    getter를 오버라이드해서 상속 받은 클래스의 private 정적 필드(클래스 필드)를 쓸 수 있게 함  
    @Override
    public int getMaxFuelAmount() {
        return MAX_FUEL_AMOUNT;
    }
}
