package com.ocp.chapter2;

// Applying Lazily Initialization to Singleton
public class VisitorTicketTracker {
    private static volatile VisitorTicketTracker instance;

    private VisitorTicketTracker() {
    }

    public static VisitorTicketTracker getInstance() {
        if (instance == null) {
            instance = new VisitorTicketTracker(); // Not thread safe!
        }
        return instance;
    }

    // double-checked locking
    // 1st check: if instance is null
    // 2nd check: being null, lock the object and then check again, if still null, create the instance
    public static VisitorTicketTracker getInstanceThreadSafe() {
        if (instance == null) {
            synchronized (VisitorTicketTracker.class) {
                if (instance == null) {
                    instance = new VisitorTicketTracker();
                }
            }
        }
        return instance;
    }
}
