package com.test.gui;

import java.awt.*;
import java.awt.event.*;
public class TestActionEvent2{
    public static void main(String args[]){
        Frame f = new Frame("TestActionEvent");
        Button btn1 = new Button("start");
        Button btn2 = new Button("stop");
        Monitor2 m2 = new Monitor2();//创建监听对象
        btn1.addActionListener(m2);
        /*一个监听对象同时监听两个按钮的动作*/
        btn2.addActionListener(m2);
        btn2.setActionCommand("GameOver");//设置btn2的执行单击命令后的返回信息
        f.add(btn1,BorderLayout.NORTH);
        f.add(btn2,BorderLayout.CENTER);
        
        f.pack();
        f.setVisible(true);
    }
}

class Monitor2 implements ActionListener{
    public void actionPerformed(ActionEvent e){
        System.out.println("a button has been pressed,"+"the relative info is:\n"+e.getActionCommand());
        /*使用返回的监听对象e调用getActionCommand()方法获取两个按钮执行单击命令后的返回信息
        根据返回信息的不同区分开当前操作的是哪一个按钮,btn1没有使用setActionCommand()方法设置
        则btn1返回的信息就是按钮上显示的文本*/
    }
}