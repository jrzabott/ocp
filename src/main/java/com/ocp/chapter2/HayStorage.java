package com.ocp.chapter2;

public class HayStorage {
    private static final HayStorage instance = new HayStorage();
    private int quantity = 0;
    private HayStorage(){}

    public static HayStorage getInstance(){
        return instance;
    }

    public synchronized void addHay(int amount){
        quantity += amount;
    }

    public synchronized boolean removeHay(int amount){
        if(quantity < amount){
            return false;
        }
        quantity -= amount;
        return true;
    }

    public synchronized int getHayQuantity(){
        return quantity;
    }
}
