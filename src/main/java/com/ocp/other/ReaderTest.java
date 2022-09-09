package com.ocp.other;

public class ReaderTest {
    public static void main(String[] args) {
        MediaReader mr = new MediaReader();
        mr.read();
    }
}

interface Classic {
    int version = 1;

    public void read();
}

class MediaReader implements Classic {
    int version = 2;
    public void read() {
        int i = ((Classic)this).version;
        System.out.println(i);
    }
}