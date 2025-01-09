package org.example.miniproject;

public interface Payable {
    int payCard(Machine machine, String productNum);
    int payCash(Machine machine, String productNum);
}
