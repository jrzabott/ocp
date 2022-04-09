package ocp.chapter2;

public class Hay extends Food {
    public Hay(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Hay consumed: " + getQuantity());
    }
}
