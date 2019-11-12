package com2018.chy.design.proxy.staticproxy;

public class Student0219 implements Person0219 {
    private String name;

    public Student0219(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name + "上交班费50元");
    }
}
