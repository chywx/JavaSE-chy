package com2018.chy.design.proxy.jdkdynamic;

public class Student0219 implements Person0219 {
    private String name;

    public Student0219(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        try {
            //假设数钱花了一秒时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上交班费50元");
    }
}
