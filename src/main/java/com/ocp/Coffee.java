package com.ocp;

public enum Coffee {
    ESPRESSO("Very Strong"), LATTE, MOCHA;
    public String strenght;
    Coffee(String s){
        this.strenght = s;
    }

    Coffee() {

    }
}
