package com.chy.design.adapter.a1;

// 类适配器，也就是extends类来实现适配功能
public class Adapter extends Usber implements Ps2 {

    @Override
    public void isPs2() {
        isUsb();
    }

}
