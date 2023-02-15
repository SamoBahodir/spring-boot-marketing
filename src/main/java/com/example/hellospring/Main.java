package com.example.hellospring;

public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        Float balans = 5000000F;
        Float oy = 10F;
        Float foiz = 0.015F;
        Type type = Type.ODDIY;
        if (type.equals(Type.ANNATIT)) {
            test.annation(balans, oy, foiz);
        } else {
            test.oddiy(balans, oy, foiz);
        }
    }

    public enum Type {
        ODDIY, ANNATIT
    }
}
