package org.example.interfaceprac;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }

    @Override
    void makeSound() {
        System.out.println("wang wang");
    }
}
