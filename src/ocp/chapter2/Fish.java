package ocp.chapter2;

public class Fish extends Food{
    public Fish(int quantity) {
        super(quantity);
    }

    @Override
    public void consumed() {
        System.out.println("Fish consumed: " + getQuantity());
    }
}
