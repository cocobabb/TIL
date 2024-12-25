package org.example.composition.game;

public class Sword extends Weapon{

    public Sword() {
        attackPower = 30;
        stamina = 110;
    }

    @Override
    public void takeDamage(int amount) {
        stamina -= (amount + attackPower);
    }

    @Override
    public void specialAttack() {

    }
}
