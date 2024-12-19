package org.example.interfaceprac.character;

public class Mage extends Character implements ManaUsable{
    protected int mana;
    protected int maxMana;
    public Mage(String name) {
        super(name);

        this.maxHp = 70;
        this.hp = maxHp;
        maxMana = 100;
        mana = maxMana;

    }

    @Override
    public void attack() {
        System.out.println("attack!");
    }

    @Override
    public void attack(Character character) {
        System.out.println("attack " + name);
        character.takeDamage(20);
    }

    @Override
    public void attack(DamageTakable character) {

    }

    @Override
    public void manaAttack(Character character) {
        System.out.println(name + " mana attack!");
        decreaseMana(20);
        character.takeDamage(40);
    }

    @Override
    public void decreaseMana(int amount) {
        mana -= amount;
    }

    @Override
    public void takeDamage(int amount) {
        hp -= amount;
    }

    @Override
    public void levelUp() {
        System.out.println("level up!");
        maxHp += 15;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("mana: " + mana);
    }
}
