package org.example;

public class Car {
    String modelName;
    int speed;

    public Car(String modelName) {
        this.modelName = modelName;
        this.speed = 0;
    }

    public void increaseSpeed(){
        this.speed +=10;
    }
    public void decreaseSpeed(){
        if(this.speed > 0){
            this.speed -= 10;
        }
    }

    public void showCarInfo(){
//        System.out.println("modelName: " + modelName + " speed: " + speed);
        System.out.printf("model: %s speed: %d\n", modelName,speed);
    }

    public int increaseSpeedByNum(int num){
        this.speed = num;
        return speed;
    }
}
