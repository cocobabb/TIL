package org.example.inheritanceprac;

public class Mage extends Character implements Attackable{
    public static final int MAX_MAGE_GAUGE = 100;

    public Mage(String name) {
        super(name, 70);
    }

    @Override
    public void levelUp(){
        super.levelUp();
        setHp(15);
    }

    @Override
    public void attackOfInterface() {
        System.out.println("attackable interface");
    }
}
