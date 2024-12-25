package org.example.composition.game;

public abstract class Weapon implements Damagable, SpecialAttackable{
    protected int attackPower;
    protected int stamina;

    public  Weapon() {
        attackPower = 20;
        stamina = 100;
    }
}
