package org.example.inheritanceprac;

public class Parents {
    public String publicValue = "public Value";
    private String privateValue = "private Value";
    protected String protectedValue = "protected Value";

    public Parents(String publicValue) {
        this.publicValue = publicValue;
    }

    public  void  publicMethod(){
        System.out.println("public method");
    }
}
