package org.example.inheritanceprac;

// extends [상속 받을 클래스 이름] => 해당 클래스의 필드 및 메서드를 가져다 쓸 수 있다(가져다 온 필드 및 메서드를 변경할 수 있음)
public class Student extends Person{
//    String name;
//    int age;
    int studentNum;

//    public  void introduce(){
//        System.out.println("hello" + name);
//    }

    public static void introduce(){
        System.out.println("hello, I'm student");
    }

    public void  study(){
        System.out.println("studying");
    }
}
