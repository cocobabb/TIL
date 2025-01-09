package org.example.miniproject;

public class Products {
    public String name;
    private int price;
    private int amount;

    public Products(String name, int price, int amount){
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount += amount;
    }

}
