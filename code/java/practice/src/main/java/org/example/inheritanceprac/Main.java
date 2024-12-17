package org.example.inheritanceprac;

public class Main {
    public static void main(String[] args) {
        Person.introduce();
        Student.introduce();

        Student s = new Student();
        s.study();

        System.out.println("---parents---");
        Parents parents = new Parents("parents public value");
        System.out.println(parents.publicValue);
//        System.out.println(parents.privateValue);
        System.out.println(parents.protectedValue);
        parents.publicMethod();



//        inheritance받은 Child 클래스는 Parents 클래스의 필드 및 메서드 이용가능
//        but Parents 클래스의 private 필드 및 메서드는 사용안됨
        System.out.println("---child---");
        Child child = new Child("child public value");
        Child c = new Child("parent public value","child public value");
        System.out.println(child.publicValue);
//        System.out.println(child.privateValue);
        System.out.println(child.protectedValue);
//      Override
        child.publicMethod();
        child.childMethod();

        Animal happy = new Animal("happy", 3);
        happy.sound();

        System.out.println("---dog---");
        Dog dog = new Dog("dog", 5, "pudle");
        dog.sound();

        System.out.println("---cat---");
        Cat cat = new Cat("cat", 4);
        cat.sound();
        cat.snoring();

        System.out.println("---vehicle---");
        Vehicle vehicle = new Vehicle("v");
        vehicle.increaseSpeed(20);
        System.out.println("vehicle speed: " + vehicle.getSpeed());
        vehicle.addFuel(100);
        System.out.println("vehicle fuel amount: " + vehicle.getFuelAmount());

        System.out.println("---Bus---");
        Bus bus = new Bus("bus", 5);
        System.out.println( "bus add Passenger: "+ bus.addPassenger(6));

        bus.addFuel(300);
        System.out.println( "bus get Fuel Amount: "+ bus.getFuelAmount());

        // 연료량이 이미 최대연료량이면 더 이상 추가 되지 않음
        bus.addFuel(30);

        System.out.println("---Truck---");
        Truck truck = new Truck("truck");
        truck.addLuggageWeight(50);
        System.out.println("truck get Luggage Weight : " + truck.getLuggageWeight());
        truck.addFuel(230);
        System.out.println("truck get Fuel Amount: " + truck.getFuelAmount());
        truck.addFuel(50);
        System.out.println("truck get Fuel Amount: " + truck.getFuelAmount());
        // 연료량이 이미 최대연료량이면 더 이상 추가 되지 않음
        truck.addFuel(50);

        System.out.println("---character---");
        Character character1 = new Character("character1");
        Character character2 = new Character("character2");
        character1.attack(character2,20);
        character1.showStatus();
        character1.attack(character2,20);
        character1.attack(character2,20);
        character1.attack(character2,20);
        character1.attack(character2,20);
        character1.showStatus();

        System.out.println("---warrior---");
        Warrior wa1 = new Warrior("wa1");
        Warrior wa2 = new Warrior("wa2");
        wa1.attack(wa2, 20);
        wa1.showStatus();
        wa1.attack(wa2, 20);
        wa1.attack(wa2, 20);
        wa1.attack(wa2, 20);
        wa1.attack(wa2, 20);
        wa1.attack(wa2, 20);
        wa1.showStatus();

        System.out.println("---mage---");
        Mage ma1 = new Mage("ma1");
        Mage ma2 = new Mage("ma2");
        ma1.attack(ma2, 20);
        ma1.showStatus();
        ma1.attack(ma2, 20);
        ma1.attack(ma2, 20);
        ma1.attack(ma2, 20);
        ma1.attack(ma2, 20);
        ma1.attack(ma2, 20);
        ma1.showStatus();
        ma2.showStatus();
        ma1.attackOfInterface();






    }
}
