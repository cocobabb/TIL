package org.example.interfaceprac;

// 이 클래스는 추상 클래스
// => 이 클래스가 가지고 있는 필드 및 메서드를 가지도록 강제함
public abstract class Shape {
    public int width;
    public int height;


    public abstract int calculateArea();

    public void  test(){
        System.out.println("test");
    }
}
