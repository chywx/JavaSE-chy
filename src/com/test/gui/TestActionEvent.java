package com.test.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestActionEvent {
    public static void main(String args[]) {
        Frame f = new Frame("TestActionEvent");
        Button btn = new Button("Press Me");
        Monitor m = new Monitor();/* 创建一个监听对象 */
        btn.addActionListener(m);
        /*
         * 把监听加入到按钮里面，监听按钮的动作， 当按钮触发打击事件时，就会返回一个监听对象e 然后就会自动执行actionPerformed方法
         */
        f.add(btn, BorderLayout.CENTER);
        f.pack();
        addWindowClosingEvent(f);
        /* 调用这个方法可以自动给Frame窗体里面的子图形元素一个合适的初始大小 */
        f.setVisible(true);
    }
    
    /**
     * 点击窗体上的关闭按钮关闭窗体
     * @param f
     */
    private static void addWindowClosingEvent(Frame f){
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                System.exit(0);
            }
            
        });
    }
}

/*
 * 自定义Monitor(监听)类实现事件监听接口ActionListener 一个类要想成为监听类，那么必须实现ActionListener接口
 */
class Monitor implements ActionListener {
    /* 重写ActionListener接口里面的actionPerformed(ActionEvent e)方法 */
    public void actionPerformed(ActionEvent e) {
        System.out.println("A Button has been Pressed");
    }
}
