package org.example.inheritanceprac;

public class Cat extends Animal{

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void sound() {
        super.sound();
        System.out.println("meow");
    }
    public void snoring(){
        System.out.println("grrr");
    }
}
