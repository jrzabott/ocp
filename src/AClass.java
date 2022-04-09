interface i1 {}

interface i2 extends i1 {}
interface i3 extends i1, i2{}

public class AClass {
    public static void main(String[] args) {
        i3 i = new i3() {
        };

    }
}