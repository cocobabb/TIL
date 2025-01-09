package org.example.miniproject;

public class Admin {
    private String name;
    private Machine machine;

    public Admin() {
        name = "lim";
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Machine getMachine() {
        return machine;
    }

    public void addProductAmount(String productNum, int amount) {
        machine.getProducts().get(productNum).setAmount(amount);
    }

    public void setProductPrice(String productNum, int price) {
        machine.getProducts().get(productNum).setPrice(price);
    }

}
