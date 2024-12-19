package org.example.interfaceprac.character;

public class Main {
    public static void main(String[] args) {
        Warrior w = new Warrior("w");

        w.attack();
        w.attack();

        Mage m = new Mage("m");
        System.out.println("<m info>");
        m.showInfo();
        System.out.println("<w info>");
        w.showInfo();

        w.attack(m);
        m.attack(w);
        m.manaAttack(w);

        System.out.println("<m info>");
        m.showInfo();
        System.out.println("<w info>");
        w.showInfo();

        m.attack(m);
    }
}
