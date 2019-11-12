package com2018.test.GUI;

import java.awt.*;

public class TestPaint {
    public static void main(String args[]) {
        new MyPaint().launchFrame();
        /*在main()方法里面并没有显示调用paint(Graphics g)方法
        可是当创建出Frame窗体后却可以看到Frame窗体上画出了
        圆和矩形，这是因为paint()方法是一个比较特殊的方法
        在创建Frame窗体时会自动隐式调用
        当我们把Frame窗体最小化又再次打开时，又会再次调用
        paint()方法重新把圆和矩形在Frame窗体上画出来
　　　　即每次需要重画Frame窗体的时候就会自动调用paint()方法*/
    }
}

class MyPaint extends Frame {
    public void launchFrame() {
        setBounds(200, 200, 640, 480);
        setVisible(true);
    }

    public void paint(Graphics g) {
        /*paint(Graphics g)方法有一个Graphics类型的参数g
        我们可以把这个g当作是一个画家，这个画家手里拿着一只画笔
        我们通过设置画笔的颜色与形状来画出我们想要的各种各样的图像*/
        /*设置画笔的颜色*/
        g.setColor(Color.red);
        g.fillOval(100, 100, 100, 100);/*画一个实心椭圆*/
        g.setColor(Color.green);
        g.fillRect(150, 200, 200, 200);/*画一个实心矩形*/
        /*这下面的两行代码是为了写程序的良好编程习惯而写的
        前面设置了画笔的颜色，现在就应该把画笔的初始颜色恢复过来
        就相当于是画家用完画笔之后把画笔上的颜色清理掉一样*/
        Color c = g.getColor();
        g.setColor(c);
    }
}
