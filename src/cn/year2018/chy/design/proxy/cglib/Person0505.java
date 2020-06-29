package cn.year2018.chy.design.proxy.cglib;

import java.io.Serializable;

public class Person0505 implements Serializable {

    private String name;

    public Person0505(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person0505() {

    }

    public void giveMoney() {
        try {
            //假设数钱花了一秒时间
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "上交班费100元");
    }

}
