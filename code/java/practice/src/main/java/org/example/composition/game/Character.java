package org.example.composition.game;

public class Character implements Attackable, Damagable {
    private String name;
    protected int hp;

    protected Weapon weapon;

    public Character(String name) {
        this.name = name;
        hp = 100;
    }
//    public Character(String name, Weapon weapon) {
//        this.name = name;
//        hp = 100;
//        this.weapon = weapon;

//    }
    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    @Override
    public void attack(Character character) {
        System.out.println(name + " attack!");

        int amount = 10;
        character.takeDamage(amount);

        if(weapon != null){
            amount+= weapon.attackPower;
            character.takeDamage(weapon.attackPower);
            weapon.takeDamage(weapon.attackPower);
        }

        System.out.printf("%s damage %d!\n", character.name, amount);
    }

    @Override
    public void takeDamage(int amount) {
        hp -= amount;
    }

    @Override
    public String toString(){
        return name;
    }

}
