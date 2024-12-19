package org.example.interfaceprac.character;

public abstract class Character implements DamageTakable{
    protected String name;
    protected int level;
    protected int hp;
    protected int maxHp;

    public Character(String name) {
        this.name = name;
        this.level = 1;
    }
    public abstract void attack();

    //  파라미터 인자로 클래스가 들어갈 수 있다(인터페이스, 추상클래스 등 다 들어갈 수 있다)
    public abstract void attack(Character character);
    // DamageTakable 인터페이스를 가지는 모든 객체가 들어갈 수 있음
    public abstract void attack(DamageTakable character); 
    
    public abstract void takeDamage(int amount);

    public  abstract void  levelUp();

    public void  showInfo(){
        System.out.println("level: " + level);
        System.out.println("hp: " + hp);
    }
    @Override
    public String toString(){
        return name;
    }
}
