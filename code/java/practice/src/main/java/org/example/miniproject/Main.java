package org.example.miniproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Drink 콜라 = new Drink("콜라", 1500, 5);
        Drink 사이다 = new Drink("사이다", 1500, 5);

        Snack 초코하임 = new Snack("초코하임", 2000, 5);
        Snack 코코넛칩 = new Snack("코코넛칩", 2000, 5);

        Machine machine = new Machine();
        machine.addProduct(콜라);
        machine.addProduct(사이다);
        machine.addProduct(초코하임);
        machine.addProduct(코코넛칩);

        machine.showProductList();

        User jeny = new User("jeny");
        jeny.setCardMoney(5000);
        jeny.setCashMoney(5000);

        jeny.showUserFinancialStatus();

        Admin admin = new Admin();
        admin.setMachine(machine);

        machine.setUser(jeny);

        System.out.println(machine.getUser().name);
        System.out.println(machine.getUser().getCardMoney());
        System.out.println(machine.getUser().getCashMoney());

        System.out.printf("사용자를 입력하세요: ");
        Scanner scanner = new Scanner(System.in);
        String user = scanner.next();
        if(user.equals("lim")){
            System.out.printf("수량 추가할 상품의 번호: ");
            String productNum = scanner.next();
            System.out.printf("수량: ");
            int productAmount =  Integer.parseInt(scanner.next());
            try {
                admin.addProductAmount(productNum, productAmount);
            }catch(NullPointerException e) {
                System.out.println(e.getMessage());
                System.out.println("없는 상품의 번호입니다. 다시 확인해 주세요");
            }
            machine.showProductList();

            System.out.printf("가격 변경할 상품의 번호: ");
            productNum =  scanner.next();
            System.out.printf("변경 가격: ");
            int productPrice =  Integer.parseInt(scanner.next());
            try {
                admin.setProductPrice(productNum,productPrice);
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
            machine.showProductList();

        } else{
            System.out.println("-----카드결제-----");
            machine.sellCardVersion();


            System.out.println("-----현금결제-----");
            machine.inputCashToMachine(1000);
            machine.sellCashVersion();
            machine.inputCashToMachine(1000);
            machine.sellCashVersion();
            machine.inputCashToMachine(1000);
            machine.sellCashVersion();
            machine.outputCashfromMachine();

            System.out.println();
            machine.inputCashToMachine(1000);
            machine.inputCashToMachine(1000);
            machine.inputCashToMachine(1000);
            machine.sellCashVersion();

            jeny.showUserFinancialStatus();
            machine.showProductList();
        }


    }
}
