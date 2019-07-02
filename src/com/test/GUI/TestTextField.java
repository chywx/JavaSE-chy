package com.test.GUI;

import java.awt.*;
import java.awt.event.*;

public class TestTextField {
    public static void main(String args[]) {
        new MyFrameTextField();
    }
}

class MyFrameTextField extends Frame {
    MyFrameTextField() {
        TextField tf = new TextField();
        add(tf);
        tf.addActionListener(new Monitor3());
        tf.setEchoChar('*');
        /*
         * 这个setEchoChar()方法是设置文本框输入时显示的字符，这里设置为*，
         * 这样输入任何内容就都以*显示出来，不过打印出来时依然可以看到输入的内容
         */
        setVisible(true);
        pack();
    }
}

class Monitor3 implements ActionListener {
    /*
     * 接口里面的所有方法都是public(公共的)
     * 所以从API文档复制void actionPerformed(ActionEvent e)时 要在void前面加上public
     */
    public void actionPerformed(ActionEvent e) {
        /* 事件的相关信息都封装在了对象e里面，通过对象e的相关方法就可以获取事件的相关信息 */
        TextField tf = (TextField) e.getSource();
        /*
         * getSource()方法是拿到事件源，注意：拿到这个事件源的时候，
         * 是把它当作TextField的父类来对待
         * getSource()方法的定义是：“public Object getSource()”返回值是一个Object对象，
         * 所以要强制转换成TextField类型的对象
         * 在一个类里面想访问另外一个类的事件源对象可以通过getSource()方法
         */
        System.out.println(tf.getText());// tf.getText()是取得文本框里面的内容
        tf.setText("");// 把文本框里面的内容清空
    }
}