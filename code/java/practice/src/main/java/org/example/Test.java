package org.example;

public class Test {
    static int value2 = 3;
    int value1;
    String name;

    public static void main(String[] args) {
        Test t = new Test(10, "h");
        t.show();

    }

    public Test(int value1, String name) {
        this.value1 = value1;
        this.name = name;
    }
    public void show(){
        System.out.println(name + "/" + Test.value2); // 정적 필드
        System.out.println(name + "/" + this.value1); // 인스턴스 필드
    }
}
