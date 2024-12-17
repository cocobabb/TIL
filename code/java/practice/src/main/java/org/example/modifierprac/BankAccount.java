package org.example.modifierprac;

public class BankAccount {
    public String name;
    private int money;
    private String password;

    public BankAccount(String name, String password, int money) {
        this.name = name;
        this.password = password;
        this.money = money;

    }

    public String makeDeposit(int money){
        if (validateAmount(money)){
            this.money+= money;
            return "Deposit of "+ String.valueOf(money);
        }
        else{
            return "Deposit of 0 is not possible";
        }
    }

    public String doWithdraw(String password, int money){
        if(validateAmount(money) && validatePassword(password)){
            this.money -= money;
            return "Withdraw of " + String.valueOf(money);
        } else if(validateAmount(money) && money > this.money) {
            return "Bigger withdraw than your money is not possible";
        }else {
            return "Fail";
        }

    }
    private boolean validateAmount(int money){
        int minAmount = 1000;
        if(money >= minAmount){
            return true;
        }else{
            return false;
        }
    }

    private boolean validatePassword(String password){
        return this.password.equals(password);
    }

    public String checkMoneyOfAccount(String password){
        if(validatePassword(password)){
            return "Money of account: " + String.valueOf(money);
        }else {
            return "It didn't work. Please,check your password again";
        }

    }
    public static boolean vailidateInitialPassword(String password){
        if(password.length()>=3){
            System.out.println("create account");
            return true;
        }else{
            System.out.println("Fail making account");
            return false;
        }
    }


}
