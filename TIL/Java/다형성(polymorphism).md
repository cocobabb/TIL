
: **상위 타입의 참조 변수로 하위 타입의 객체를 참조할 수 있게 하는 특성**
- **상위 타입에 정의된 필드 및 메서드 종류만 사용 가능**
- 생성된 인스턴스는 하위 타입의 객체이므로 **메서드는 하위 타입에 오버라이딩 된 메서드를 씀**

```Java
        Vehicle polyBus = new Bus("polyBus");
        polyBus.vehicleMethod();
// => Bus 인스턴스는 Vehicle을 상속 받으므로 Bus에 해당 메서드가 정의 되어 있지 않아도 쓸 수 있음
        polyBus.fuelMethod();
// => 타입은 Vehicle이지만 생성된 인스턴스는 Bus이므로 쓰이는 메서드는 오버라이딩 된 메서드를 씀
        System.out.println(polyBus.vehicleValue);
// => Bus 인스턴스는 Vehicle을 상속 받으므로 Bus에 해당 필드가 정의 되어 있지 않아도 쓸 수 있음
//      System.out.println(polyBus.busValue);
// => Bus 클래스에는 정의 되어 있는 필드지만 Vehicle 클래스에는 정의 되어 있지 않아서 쓸수 없음
//      polyBus.passengerMethod();
// => Bus 클래스에는 정의 되어 있는 메서드지만 Vehicle 클래스에는 정의 되어 있지 않아서 쓸수 없음
```

```Java
// class는 사용자 정의 타입으로써 아래와 같이 형변환 가능
Bus bus2 = (Bus) polyBus;
```
****
```Java
    // 다형성을 이용한 불필요한 오버로딩을 줄이는 방법  
    static void vehicleMethod(Vehicle vehicle) {  
//       Vehicle 관련 기능만 수행  
        vehicle.fuelMethod();  
        vehicle.speedMethod();  
    }
```
```Java
    // 위와 같은 방법을 쓰지 않은 경우
    // 아래와 같이 들어오는 객체 타입에 따라 오버로딩을 해야함
    static void vehicleMethod(Bus bus) {  
        vehicle.fuelMethod();  
        vehicle.speedMethod();  
    }
    static void vehicleMethod(Truck truck) {  
        vehicle.fuelMethod();  
        vehicle.speedMethod();  
    }
    static void vehicleMethod(Brucks brucks) {  
        vehicle.fuelMethod();  
        vehicle.speedMethod();  
    }

```
```Java
//      다형성을 이용한 불필요한 오버로딩을 줄이는 방법  
        System.out.println("----다형성을 이용한 불필요한 오버로딩을 줄이는 방법----");  
        vehicleMethod(bus);  
        vehicleMethod(truck);  
        vehicleMethod(brucks);  
```



### 위와 같은 코드가 쓰이는 경우

- 결제 시스템
	=> 세모페이, 네모페이, 동그라미페이 등등 여러 페이 객체에 따라 상품이 결제 될 수 있도록
	결제 메서드에 파라미터 타입을 페이들의 상위 타입인 결제클래스로 설정하면 여러 페이에 따라 결제 메서드를 여러 개 생성할 필요가 없다 => 오버로딩 필요성이 없어짐