package com.edu.testPay;

import org.junit.Test;

public class Test0123 {
    @Test
    public void test2(){
        String totalFee = "0.1";
        System.out.println((int)(Double.parseDouble(totalFee)*100) +"");
    }

    @Test
    public void test3(){
        Double double1 = 0d;
        double1 += 11.2;
        double1 += 2;
        System.out.println((int)(double1*100));

        String string = "13.2";
        Double valueOf = Double.valueOf(string);
        System.out.println((int)(valueOf*100));

        System.out.println((int)(double1*100) == (int)(valueOf*100));
    }
}
