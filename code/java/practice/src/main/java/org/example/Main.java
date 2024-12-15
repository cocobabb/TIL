package org.example;


import org.example.javaIntro.Dog;

import static org.example.javaIntro.Coffee.taste;

public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(3);
        System.out.println(c1.radius);
        System.out.println(c1.calculateArea());

        System.out.println("--------person-------");
        Person p = new Person("Nick", 18);
        System.out.println("name: " + p.name +" age:" + p.age);

//      다른 패키지에 있는 클래스 인스턴스 생성 => import 필요
        System.out.println("--------Dog-------");
        Dog d = new Dog("Bichon","Gurm");
        d.SeatDown();
        d.giveHand();

        System.out.println("--------Triangle-------");
        Triangle t = new Triangle(4);
        System.out.println("Circumference: "+ t.calculateCircumference());
        System.out.println("Area: "+ t.calculateArea());

        System.out.println("--------Car-------");
        Car c = new Car("Avante");
        System.out.println("modelName: "+c.modelName);
        System.out.println("speed: "+c.speed);
        c.increaseSpeed();
        c.increaseSpeed();
        c.increaseSpeed();
        System.out.println("speed: "+c.speed);
        c.decreaseSpeed();
        System.out.println("speed: "+c.speed);
        c.showCarInfo();
        c.increaseSpeedByNum(110);
        c.showCarInfo();

        System.out.println("--------Mp3Player-------");
        Mp3Player m = new Mp3Player("iPod");
        m.pushPowerBtn();
        m.increaseVolume();
        m.increaseVolume();
        m.increaseVolume();
        m.decreaseVolume();
        m.showPlayerInfo();
        m.pushPowerBtn();
        m.showPlayerInfo();
        m.increaseVolume();
        m.increaseVolume();
        m.increaseVolume();
        m.showPlayerInfo();
        m.pushPowerBtn();
        m.decreaseVolume();
        m.decreaseVolume();
        m.decreaseVolume();
        m.decreaseVolume();
        m.showPlayerInfo();
        System.out.println("--------Calculator-------");
        Calculator cal = new Calculator();
        System.out.println(cal.add(10,4));
//        클래스에서 클래스 메서드에 접근
        System.out.println(Calculator.staticAdd(10,4)); 
//        인스턴스에서 클래스 메서드에 접근
        System.out.println(cal.staticAdd(10,4));

//        다른 패키지에 있는 클래스 메서드 실행 => import 필요
        taste();





    }
}
