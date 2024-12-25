package org.example.composition.game;

public class Main {
    public static void main(String[] args) {
        Gun gun = new Gun();
        Sword sword = new Sword();

        Character c1 = new Character("c1");
        Character c2 = new Character("c2");
        c2.setWeapon(gun);

        c1.attack(c2);
        c2.attack(c1);
        System.out.println("c1 hp: " + c1.hp);

        // 문제상황
//          - Weapon는 SpecialAttackable을 가지지 않음
//          - Weapon을 상속 받는 자식 클래스들은 SpecialAttackable을 가짐
//              =>무기마다 해당 구현부가 각각 다를 거 같아서 각각 implements 되어 구현되어야 한다고 생각함
//          - Weapon 부모 클래스이므로 자식 클래스에서 implements한 SpecialAttackable을 알지 못함  
//          - Character는 Weapon만 받을 수 있음(불필요한 오버로딩 피하기 위한 설정) => SpecialAttackable의 메서드 오버라이딩이 불가능 함

        //해결방안
//        1. Weapon이 SpecialAttackable 인터페이스를 가지고 Weapon은 아무것도 안함을 가지고 해당 메서드 자식 클래스들은 각각 다르게 구현함
//                => 이 방안 채택!!
//        2. Charater의 SA 메서드 내부에서 Weapon이 SAable을 구현하는지 확인함 => ?
        // instanceof 라는 연산자를 사용
//        3. Weapon이 SA을 composition으로 가짐
        // SA이 null인지를 확인해서 진행 =>  ?
    }
}
