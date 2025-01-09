package org.example.collectionprac.generic;

public class Main {
    public static void main(String[] args) {
        GenericPrac<Integer> intergerGenericPrac = new GenericPrac<>();

        intergerGenericPrac.setValue(123);
        System.out.println(intergerGenericPrac.getValue());

//      intergerGenericPrac의 인스턴스 생성 시 Generic 타입이 Integer로 들어가서 String 타입은 들어갈 수 없음
//        intergerGenericPrac.setValue("123");

        GenericPrac<String> stringGenericPrac = new GenericPrac<>();
//      stringGenericPrac의 인스턴스 생성 시 Generic 타입이 String로 들어가서 String 타입 들어갈 수 있음
        stringGenericPrac.setValue("123");
        System.out.println(stringGenericPrac.getValue());
//       반대로, Integer 타입의 값이 들어갈 수 없음
//        stringGenericPrac.setValue(123);

//        GenericPrac 클래스의 Generic 타입을 내가 임의로 정의하면 이와 같이 다형성(polymorphism) 할 수 있음
    }
}
