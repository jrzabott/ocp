package com.ocp.other;


import java.io.*;
import java.util.Optional;

class Boo {
    int boo = 10;

    public Boo(int k) {
        System.out.println("In Boo k = " + k);
        boo = k;
    }
}

class BooBoo extends Boo {
    public BooBoo(int k) {
        super(k);
        System.out.println("In BooBoo k = " + k);
    }
}

class Moo extends BooBoo implements Serializable {
    int moo = 10;

    public Moo() {
        super(5);
        System.out.println("In Moo");
    }
}

public class TestClassAgain {
    public static void main(String[] args) throws Exception {
        // extracted();

        //extracted1();

        Optional.of(getValue());
    }

    private static void extracted1() {
        try{m2();}catch (Exception e){
            Throwable[] a = e.getSuppressed();
            for (Throwable supressed: a
                 ) {
                System.out.println(supressed.getMessage());
            }

            System.out.println(e.getMessage());
            System.out.println(e.getSuppressed().length);
            System.out.println(e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

    private static void extracted() throws IOException, ClassNotFoundException {
        Moo moo = new Moo();
        FileOutputStream fos = new FileOutputStream("c:\\temp\\moo1.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(moo);
        os.close();
        FileInputStream fis = new FileInputStream("c:\\temp\\moo1.ser");
        ObjectInputStream is = new ObjectInputStream(fis);
        moo = (Moo) is.readObject();
        is.close();
    }

    static void m1() throws Exception {
        throw new Exception("From m1");
    }

    static void m2() throws Exception {
        try {
            m1();
        } catch (Exception e) {
            throw e;
        } finally {
            throw new RuntimeException("From finally");
        }
    }
static String getValue(){
        return null;
}

}
