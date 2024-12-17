package org.example.inheritanceprac;

public class Warrior extends  Character{
    private int angerGauge;
    public static final int MAX_ANGER_GAUGE = 100;

    public Warrior(String name) {
        super(name, 120);
        this.angerGauge = 0;
    }

    @Override
    public void attack(Character character, int damage) {
        super.attack(character, damage);
        if(angerGauge != MAX_ANGER_GAUGE){
            angerGauge += damage;
        }
    }

    @Override
    public void levelUp() {
        super.levelUp();
        setHp(30);
        setMaxHp(30);
    }



}
