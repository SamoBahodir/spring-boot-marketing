package com.example.hellospring;

import java.util.Scanner;

public class Test {
    public void oddiy(Float balans,Float oy,Float foiz) {
        Float sum = 0F, assasiyQarz = balans / oy,
                jamiOylikTolov = balans / oy;
        Float jamiAssosiyQarz = 0F,
                jamiFoiz = 0F,
                jamiBalans = 0F;
        for (float d = 0; d < oy; d++) {
            sum = balans * foiz;
            jamiOylikTolov += sum;
            System.out.println(jamiOylikTolov);
            jamiAssosiyQarz += assasiyQarz;
            jamiOylikTolov = assasiyQarz;
            jamiFoiz += sum;
            jamiBalans += balans;
            balans = balans - jamiOylikTolov;
        }
        System.out.println("--------------------------");
        System.out.println("jamiBalans -->" + jamiBalans);
        System.out.println("% -->" + jamiFoiz);
        System.out.println("jamiAssosiyQarz -->" + jamiAssosiyQarz);
        System.out.println("jamiOylikTolov1-->" + (jamiAssosiyQarz + jamiFoiz));
    }

    public void annation(Float balans,Float oy,Float foiz) {
        Float sum = 0F, assasiyQarz = balans / oy,
                jamiOylikTolov = balans / oy;
        Float jamiAssosiyQarz = 0F,
                jamiFoiz = 0F,
                jamiBalans = 0F;
        for (float d = 0; d < oy; d++) {
            sum = balans * foiz;
            jamiOylikTolov += sum;
            System.out.println(""+jamiOylikTolov);
            jamiAssosiyQarz += assasiyQarz;
            jamiOylikTolov = assasiyQarz;
            jamiFoiz += sum;
            jamiBalans += balans;
            balans = balans - jamiOylikTolov;
        }
        System.out.println("--------------------------");
        System.out.println("jamiBalans -->" + jamiBalans);
        System.out.println("% -->" + jamiFoiz);
        System.out.println("jamiAssosiyQarz -->" + jamiAssosiyQarz);
        System.out.println("jamiOylikTolov1-->" + (jamiAssosiyQarz + jamiFoiz));
    }

}
