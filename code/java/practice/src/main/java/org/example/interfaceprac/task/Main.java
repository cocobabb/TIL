package org.example.interfaceprac.task;

public class Main {
    public static void main(String[] args) {
        System.out.println("----bus----");
        Bus bus = new Bus("bus ");
        bus.vehicleMethod();
//         => Bus 인스턴스는 Vehicle을 상속 받으므로 Bus에 해당 메서드가 정의 되어 있지 않아도 쓸 수 있음
        bus.passengerMethod();
        bus.fuelMethod();
        bus.speedMethod();
        System.out.println(bus.busValue);

        System.out.println("----다형성 bus----");
//      다형성(polymorphism)
//      => 상위 타입의 참조 변수로 하위 타입의 객체를 참조
//      => 상위 타입에 정의된 필드 및 메서드 종류만 사용 가능
//      => 생성된 인스턴스는 하위 타입의 객체이므로 메서드는 하위 타입에 오버라이딩 된 메서드를 쓴다.

        Vehicle polyBus = new Bus("polyBus");
        polyBus.vehicleMethod();
//        => Bus 인스턴스는 Vehicle을 상속 받으므로 Bus에 해당 메서드가 정의 되어 있지 않아도 쓸 수 있음
        polyBus.fuelMethod();
//        => 타입은 Vehicle이지만 생성된 인스턴스는 Bus이므로 쓰이는 메서드는 오버라이딩 된 메서드를 씀
        System.out.println(polyBus.vehicleValue);
//        => Bus 인스턴스는 Vehicle을 상속 받으므로 Bus에 해당 필드가 정의 되어 있지 않아도 쓸 수 있음
//        System.out.println(polyBus.busValue);
//        => Bus 클래스에는 정의 되어 있는 필드지만 Vehicle 클래스에는 정의 되어 있지 않아서 쓸수 없음
//        polyBus.passengerMethod();
//        => Bus 클래스에는 정의 되어 있는 메서드지만 Vehicle 클래스에는 정의 되어 있지 않아서 쓸수 없음

        System.out.println("----다형성 bus 다시 bus로 형변환----");
//      타입을 Bus로 설정하면 Vehicle에 정의된 필드 및 메서드와 Bus에 정의된 필드 및 메서드 종류를 다 쓸 수 있다
        Bus bus2 = (Bus) polyBus;
        bus2.vehicleMethod();
//        => Bus 인스턴스는 Vehicle을 상속 받으므로 bus2에 해당 메서드가 정의 되어 있지 않아도 쓸 수 있음
        bus2.passengerMethod();
        bus2.speedMethod();
        bus2.fuelMethod();
        System.out.println(bus2.busValue);
        System.out.println(bus2.vehicleValue);

        System.out.println("----truck----");
        Truck truck = new Truck("truck");
        truck.vehicleMethod();
//        => Truck 인스턴스는 Vehicle을 상속 받으므로 truck에 해당 메서드가 정의 되어 있지 않아도 쓸 수 있음
        truck.speedMethod();
        truck.fuelMethod();
        truck.luggageMethod();

        System.out.println("----brucks----");
        Brucks brucks = new Brucks("brucks");
        brucks.vehicleMethod();
//        => Brucks 인스턴스는 Vehicle을 상속 받으므로 brucks에 해당 메서드가 정의 되어 있지 않아도 쓸 수 있음
        brucks.speedMethod();
        brucks.fuelMethod();
        brucks.luggageMethod();
        brucks.passengerMethod();

//      다형성을 이용한 불필요한 오버로딩을 줄이는 방법
        System.out.println("----다형성을 이용한 불필요한 오버로딩을 줄이는 방법----");
        vehicleMethod(bus);
        vehicleMethod(truck);
        vehicleMethod(brucks);
        vehicleMethod(polyBus);
    }

    //      다형성을 이용한 불필요한 오버로딩을 줄이는 방법
    static void vehicleMethod(Vehicle vehicle) {
//       Vehicle 관련 기능만 수행
        vehicle.fuelMethod();
        vehicle.speedMethod();
    }
}
