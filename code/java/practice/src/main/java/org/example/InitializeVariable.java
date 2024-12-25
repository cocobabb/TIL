package org.example;

public class InitializeVariable {
    public static void main(String[] args) {
        V1 v1 = new V1();
        System.out.println(v1.value);
        System.out.println();

        V2 v2 = new V2();
        System.out.println(v2.value);
        System.out.println();

        V3 v3 = new V3();
        System.out.println(v3.value);
    }

}
class V1{
    static int staticValue = 30;
    int value = 10;
    String word = "Text";
}
class V2{
    int value;
    String word;

    public V2() {
        this(10, "Text");
    }
    public V2(int value, String word){
        this.value = value;
        this.word = word;
    }
}
class V3{
    static int staticValue;
    int value;
    String word;

    static {
        if(true){
            staticValue = 30;
        }else {
            staticValue = 50;
        }
    }

    {
        if(true){
            this.value = 10;
        }else {
            this.value = 1;
        }

        this.word = "Text";

    }

}
