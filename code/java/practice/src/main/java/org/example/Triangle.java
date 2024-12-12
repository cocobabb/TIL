package org.example;

public class Triangle {
    int side;

    public Triangle(int side) {
        this.side = side;
    }

    public int calculateCircumference(){
        return side*3;
    }
    public double calculateArea(){
        double area = (Math.sqrt(3)/4) * side * side;
        area = Math.floor(area*100);
        return  area;
    }


}
