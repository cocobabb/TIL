package org.example.modifierprac;

public class Person {
    private String name;
    public int age;
    private double height;

    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    private void running(){
        System.out.printf("age: %d / %s is running.\n",this.age,getName());
    }
    public void doRunning(){
        running();
    }
    public void walking(){
        System.out.printf("age: %d / %s is walking\n",this.age,getName());
    }
    void study(){
        System.out.println("--Info of studied person--");
        System.out.println("name: " + getName());
        System.out.println("age: " + this.age);
        System.out.println("height: " + getHeight());
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
