package org.example.collectionprac.generic;
// GenericPrac 클래스의 Generic 타입을 내가 임의로 정의하면 다형성(polymorphism) 할 수 있음
// T의 자료형 타입 Integer, String, (사용자 정의 Class, Interface) 등 다 가능 => 다형성

public class GenericPrac<T> {
    public  T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
