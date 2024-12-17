package org.example.modifierprac;

public class Main {
    public static void main(String[] args) {

        System.out.println("----Person----");
        Person Nick = new Person("Nick", 18, 185.6);
        System.out.println(Nick.getName());
        System.out.println(Nick.age);
        System.out.println(Nick.getHeight());

        Nick.doRunning();
        Nick.walking();
        Nick.study();

        System.out.println("----BankAccount----");
        String password = "abc";
        if(BankAccount.vailidateInitialPassword(password)){
            BankAccount Jin = new BankAccount("Jin",password, 1000);
            System.out.printf("%s %s\n",Jin.name ,Jin.checkMoneyOfAccount(password));

            System.out.printf(  "%s / %s\n",Jin.name,Jin.makeDeposit(1000));
            System.out.printf("%s %s\n",Jin.name ,Jin.checkMoneyOfAccount("abc"));

            System.out.printf(  "%s / %s\n",Jin.name,Jin.doWithdraw("16b", 1000));
            System.out.printf("%s %s\n",Jin.name ,Jin.checkMoneyOfAccount(password));
        }





    }


}