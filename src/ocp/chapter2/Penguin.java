package ocp.chapter2;

public class Penguin {
    private final Flippers flippers;
    private final WebbedFeet webbedFeet;

    public Penguin(){
        this.flippers = new Flippers();
        this.webbedFeet = new WebbedFeet();
    }

    public void flap(){
        flippers.flap();
    }

    public void kick(){
        webbedFeet.kick();
    }
}
