package org.example.interfaceprac.character;

public class Warrior extends Character implements RageUsable{
    protected int rage;
    protected int maxRage;

    public Warrior(String name) {
        super(name);

        this.maxHp = 120;
        this.hp = maxHp;
        this.maxRage = 100;
        this.rage = 0;
    }

    @Override
    public void attack() {
        System.out.println("attack!");
        if(rage == maxRage){
            rageAttack();
        }
    }

    @Override
//   파라미터 인자로 클래스가 들어갈 수 있다(인터페이스, 추상클래스 등 다 들어갈 수 있다)
    public void attack(Character character) {
        System.out.println("attack " + name);
        character.takeDamage(20);
    }
//  DamageTakable 인터페이스를 가지는 모든 객체가 들어갈 수 있음
//  위에 Character 타입 객체를 받는 경우와 차이점
//  => 특정 객체뿐만 아니라 DamageTakable 인터페이스를 가지는 모든 객체가 들어갈 수 있음
//  => 즉, 다양한 객체가 해당 메서드에 영향을 받을 수 있다는 것
    @Override
    public void attack(DamageTakable character) {
        System.out.println("attack" + name);
        character.takeDamage(20);
    }

    @Override
    public void takeDamage(int amount) {
        hp -= amount;
        increaseRage(amount);
    }

    @Override
    public void levelUp() {
        System.out.println("level up!");
        maxHp += 30;
    }

    @Override
    public void increaseRage() {
        rage = Math.min(maxRage, rage + 10);
    }

    @Override
    public void increaseRage(int amount) {
        rage += 10;
//        if(rage >= maxRage){
//            rage = maxRage;
//        }

//        위와 같은 코드
//        Math.min() => 두 인자 값 중 작은 값 리턴
        rage = Math.min(maxRage, rage + amount);
    }

    @Override
    public void rageAttack() {
        System.out.println(name + " rage attack!");
        rage = 0;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("rage: " + rage);
    }

}
