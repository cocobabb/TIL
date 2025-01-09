package org.example.miniproject;

public class User{
    protected String name;
    private int cardMoney;
    private int cashMoney;

    public User(String name) {
        this.name = name;
        this.cardMoney = 0;
        this.cashMoney = 0;
    }

    public int getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(int cardMoney) {
        this.cardMoney += cardMoney;
    }

    public int getCashMoney() {
        return cashMoney;
    }

    public void setCashMoney(int cashMoney) {
        this.cashMoney += cashMoney;
    }

    public void showUserFinancialStatus(){

        System.out.printf("<%s>\n",name);
        System.out.println("cardMoney: " + cardMoney);
        System.out.println("cashMoney: " + cashMoney);
    }



//    status: 결제는 사람이 하는 행동이라 생각하여 payCard 또는 payCash등의 메서드를 가진 payable 인터페이스를 만들어
//            User 클래스에 implements함 
//        => 메서드에 Machine 타입의 파라미터가 들어감 => 머신의 있는 상품 정보에 대해 가져올 수 있음

//    문제상황: 사용자는 기계(자판기)의 상품 가격을 알지만 기계는 사용자의 지불 금액을 알지 못하여
//             카드의 잔액부족이나 현금의 거스름돈을 계산 할 수 없음
    
//    해결방안: Machine 클래스에서 User 클래스를 컴포지션으로 가져서 처리

//    @Override
//    public int payCard(Machine machine, String productNum) {
//        machine.sell(productNum);
//        cardMoney -= machine.products.get(productNum).price;
//        return cardMoney;
//    }

//    @Override
//    public int payCash(Machine machine, String productNum) {
//        machine.sell(productNum);
//        cashMoney -= machine.products.get(productNum).price;
//        return cashMoney;
//    }
}
