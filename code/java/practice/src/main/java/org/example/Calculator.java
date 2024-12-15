package org.example;

public class Calculator { 
//    인스턴스 메서드 => 인스턴스에서만 접근 가능
//    클래스 메서드 또는 정적 메서드 => 클래스, 인스턴스 둘 다 접근 가능
//    덧셈(인스턴스 메서드) 
    int add(int num1, int num2){
        return num1 + num2;
    }
//    덧셈(클래스 메서드 또는 정적 메서드) 
    static int staticAdd(int num1, int num2){
        return num1 + num2;
    }
//    뺄셈(인스턴스 메서드)
    int minus(int num1, int num2){
        return  num1 - num2;
    }
//    곱셈(인스턴스 메서드)
    int multiply(int num1, int num2){
        return num1 * num2;
    }
//    나눗셈(인스턴스 메서드)
    double divide(int num1, int num2){
        return  (double) num1 /num2;
    }



}
