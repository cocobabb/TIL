package org.example.composition;

public class Car implements Acceleratable,Tool {
    String modelName;
    Engine engine;
    int speed;
    int accleration;


//    public Car(String modelName, Engine engine) {
//        this.modelName = modelName;
//        this.engine = engine;
//        this.speed = 0;
//        accleration = 0;
//    }
    public Car(String modelName, Engine engine) {
        this.modelName = modelName;
        this.engine = engine;
        this.speed = 0;
        accleration = 0;
    }

    @Override
    public void acclerate() {
        accleration = (engine.horsePower/10);
        speed += accleration;
        System.out.println("mana: " + engine.horsePower);
        System.out.println("accleration: " + accleration);
        System.out.println("speed: " + speed);

    }

    @Override
    public void useTool() {
        acclerate();
    }
}
