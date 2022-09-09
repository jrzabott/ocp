package com.ocp.other;

public class BankAccount implements PremiumAccount{
    public static void main(String[] args) {
        Account a = new BankAccount();
        System.out.println(a.getId());
    }

    @Override
    public String getId() {
        return null;
    }
}

interface Account{
    default String getId(){
        return "0000";
    }
}
interface PremiumAccount extends Account{
    String getId();
}
