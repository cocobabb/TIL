package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Circle c1 = new Circle(3);
        System.out.println(c1.radius);
        System.out.println(c1.calculateArea());

        System.out.println("--------person-------");
        Person p = new Person("Nick", 18);
        System.out.println("name: " + p.name +" age:" + p.age);

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

    }
}
