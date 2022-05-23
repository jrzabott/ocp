package com.ocp.chapter2;

public class StaffRegister {
    private static final StaffRegister instance;

    static {
        instance = new StaffRegister();
        // Perform additional steps here
    }

    private StaffRegister() {}

    public static StaffRegister getInstance() {
        return instance;
    }
}
