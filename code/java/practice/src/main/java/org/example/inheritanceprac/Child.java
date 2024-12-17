package org.example.inheritanceprac;

public class Child  extends Parents{
    public String childValue = "childValue";

    public Child(String publicValue) {
        super((publicValue));
    }

    public Child(String parentsValue, String childValue) {
        super(parentsValue);
        this.childValue = childValue;
    }

    public  void  childMethod(){
        System.out.println("childMethod");
    }

//    override
    @Override
    public void publicMethod() {
//        super.[상속 받은 클래스의 메서드 및 필드]
//        => 상속 받은 클래스의 메서드 및 필드에 접근해서 가져올 수 있음
        super.publicMethod();
        System.out.println(super.publicValue);
        System.out.println(super.protectedValue);
        System.out.println("chile public method");
    }
}
