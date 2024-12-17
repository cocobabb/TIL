package org.example.interfaceprac;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle();
        System.out.println(rectangle.calculateArea());

        Shape triangle = new Triangle();
        System.out.println(triangle.calculateArea());
        
//        추상 클래스는 자신의 instance 만들 수 없음
//        => 다형성을 위한 상위 타입의 역할만 수행하기 때문에
//        new Animal()
        System.out.println("---------Animal----------");
       Dog dog = new Dog ("happy", 18, "puddle");
//     다형성(polymorphism)
//     => 상속 받는 클래스(상위) 타입으로 상속 받은(하위) 클래스 인스턴스 생성
       Animal ad = new Dog ("ad", 18, "puddle");
       dog.makeSound();
       ad.makeSound();

       Cat cat = new Cat("cat", 3);
//     다형성(polymorphism)
       Animal ac = new Cat("cat", 3);
       cat.makeSound();
       ac.makeSound();
       cat.grr();
//       ac.grr();
//        => grr 메서드는 Cat 클래스에서 implements 된 것이라 쓸 수 없음
//        => 다형성 때문

       makeThemSound(dog);
       makeThemSound(cat);
    }
    public static void makeThemSound(Animal animal){
        System.out.println("----makeThemSound method----");
        System.out.println("cry!");
        animal.makeSound();
    }
}
