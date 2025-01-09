package org.example.miniproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Machine {
    private int productNum;
    private Map<String, Products> products;
    private User user;
    private int machineMoney;
    private int tempoMachineMoney;

    public Machine() {
        this.products =  new HashMap<>();
        this.productNum = 1;
    }

    public Map<String, Products> getProducts() {
        return products;
    }

    protected void addProduct(Products product) {
        products.put(String.valueOf(productNum), product);
        productNum++;
    }


    protected void setUser(User user) {
        this.user = user;
    }

    protected User getUser() {
        return user;
    }
//    User을 컴포지션으로 가지고 유저를 기계에 set해서 결제 금액을 계산
    protected void sellCardVersion() {
        Scanner scanner = new Scanner(System.in);
        Products product = null;
        int productNum = 0;
        do {
            System.out.printf("상품의 번호를 입력하세요: ");
            String inputProductNum = scanner.next();
            product = products.get(inputProductNum);

            productNum = Integer.parseInt(inputProductNum);
        }while (!(productNum > 0 && productNum <= products.size()));

         if(product.getAmount() != 0 && user.getCardMoney() <= product.getPrice()){
             System.out.printf("카드의 잔액이 부족합니다. 카드 잔액: %d\n", user.getCardMoney());
             return;
         }else if(product.getAmount() != 0 && user.getCardMoney() > product.getPrice()) {
             product.setAmount(-1);
             user.setCardMoney(-product.getPrice());
             System.out.printf("카드로 %s 제품이 결제되었습니다.\n", product.name);
             return;
         }

    }

    protected void inputCashToMachine(int amount){
        user.setCashMoney(-amount);
        machineMoney += amount;
        tempoMachineMoney += amount;
        System.out.printf("투입 금액: %d\n", tempoMachineMoney);
    }

    protected void outputCashfromMachine(){
        machineMoney -= tempoMachineMoney;
        System.out.printf("%d원이 반환됩니다.", tempoMachineMoney);
        user.setCashMoney(tempoMachineMoney);
        tempoMachineMoney = 0;
    }

    protected void sellCashVersion() {
        Scanner scanner = new Scanner(System.in);
        Products product = null;
        int productNum = 0;
        do {
            System.out.printf("상품의 번호를 입력하세요: ");
            String inputProductNum = scanner.next();
            product = products.get(inputProductNum);

            productNum = Integer.parseInt(inputProductNum);
        }while (!(productNum > 0 && productNum <= products.size()));

        if(product.getAmount() != 0 && tempoMachineMoney < product.getPrice()){
            System.out.printf("현금이 부족합니다. 투입 금액: %d\n", tempoMachineMoney);
            return;
        }else{
            if(product.getAmount() != 0 && tempoMachineMoney == product.getPrice()){
                product.setAmount(-1);
                System.out.printf("현금으로 %s 제품이 결제되었습니다.\n", product.name);
                tempoMachineMoney = 0;
                return;
            }else{
                product.setAmount(-1);
                System.out.printf("현금으로 %s 제품이 결제되었습니다.\n", product.name);
                int remainCashMoney = tempoMachineMoney - product.getPrice();
                System.out.printf("남은 현금 %d원이 반환됩니다.\n", remainCashMoney);
                tempoMachineMoney = 0;
                machineMoney -= remainCashMoney;
                user.setCashMoney(remainCashMoney);
                return;
            }
        }

    }

    protected void showProductList(){
        System.out.println("<상품 목록>");
        for(String productNum : products.keySet()){
            System.out.printf( "%s: %s(%d) %d원\n",productNum,products.get(productNum).name,products.get(productNum).getAmount(), products.get(productNum).getPrice());
        }
    }


}
