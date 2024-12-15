package org.example.javaIntro;

public class Dog {
    String breed;
    String name;

    public Dog(String breed, String name) {
        this.breed = breed;
        this.name = name;
    }

    public void SeatDown(){
        System.out.println("breed = " + breed);
        System.out.println(name+" Seat down");
    }
    public void giveHand(){
        System.out.println("breed = " + breed);
        System.out.println(name+" Give hand");
    }

}
