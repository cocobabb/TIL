package org.example.composition.game;

public class Gun extends Weapon {

    public Gun() {
        attackPower = 30;
        stamina = 110;
    }

    @Override
    public void takeDamage(int amount) {
        stamina -= (amount);
        System.out.printf("무기 내구력: %d\n", stamina);
    }

    @Override
    public void specialAttack() {

    }
}
