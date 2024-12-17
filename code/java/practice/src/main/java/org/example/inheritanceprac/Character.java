package org.example.inheritanceprac;

public class Character {
    private String name;
    private int level;
    private int hp;
    private int maxHp;
    private int exp;

    public Character(String name) {
        this.name = name;
        this.level = 1;
        this.hp = 100;
        this.maxHp = 100;
    }

    public Character(String name, int hp) {
        this.name = name;
        this.hp = hp;
        this.level = 1;
    }

    public void attack(Character character, int damage) {
//       인자 객체에게 데미지를 입힘
        character.damaged(damage);
//        주체 객체는 경험치를 얻음
        exp += damage;
        System.out.println("attack! " + name);

        if(exp == 100){
            levelUp();
        }
    }

    public void damaged(int damage) {
        System.out.println( "attacked "+ name);
        hp-=damage;
    }

    public void levelUp() {
        level += 1;
        System.out.println("level up!");
        exp = 0;
    }

    public void showStatus(){
        System.out.println("name: " + name);
        System.out.println("level: " + level);
        System.out.println("hp: " + hp);
        System.out.println("exp: " + exp);
    }

    public int setHp(int hp) {
        return this.hp += hp;
    }
    public int setMaxHp(int maxHp){
        return this.maxHp += hp;
    }


}