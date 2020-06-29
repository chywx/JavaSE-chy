package cn.year2018.test.GUI;

import java.awt.*;
import java.awt.event.*;

public class TestMath {
    public static void main(String args[]) {
        new TFFrame();
    }
}

/* 这里主要是完成计算器元素的布局 */
class TFFrame extends Frame {
    TFFrame() {
        /*
         * 创建3个文本框，并指定其初始大小分别为10个字符和15个字符的大小 这里使用的是TextField类的另外一种构造方法 public TextField(int columns)
         */
        TextField num1 = new TextField(10);
        TextField num2 = new TextField(10);
        TextField num3 = new TextField(15);
        /* 创建等号按钮 */
        Button btnEqual = new Button("=");
        btnEqual.addActionListener(new MyMonitor(num1, num2, num3));
        /* 给等号按钮加上监听，让点击按钮后有响应事件发生 */
        Label lblPlus = new Label("+");
        /* “+”是一个静态文本，所以使用Label类创建一个静态文本对象 */
        setLayout(new FlowLayout());
        /* 把Frame默认的BorderLayout布局改成FlowLayout布局 */
        add(num1);
        add(lblPlus);
        add(num2);
        add(btnEqual);
        add(num3);
        pack();
        setVisible(true);

    }
}

class MyMonitor implements ActionListener {
    TextField num1, num2, num3;

    /*
     * 为了使对按钮的监听能够对文本框也起作用，
     * 所以在自定义类MyMonitor里面定义三个TextField类型的对象 num1,num2,num3,
     * 并且定义了MyMonitor类的一个构造方法 这个构造方法带有三个TextField类型的参数，
     * 用于接收 从TFFrame类里面传递过来的三个TextField类型的参数
     * 然后把接收到的三个TextField类型的参数赋值给在本类中声明的 三个TextField类型的参数num1,num2,num3 然后再在actionPerformed()方法里面处理num1,num2,num3
     */
    public MyMonitor(TextField num1, TextField num2, TextField num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    public void actionPerformed(ActionEvent e) {
        /* 事件的相关信息都封装在了对象e里面，通过对象e的相关方法就可以获取事件的相关信息 */
        int n1 = Integer.parseInt(num1.getText());/* num1对象调用getText()方法取得自己显示的文本字符串 */
        int n2 = Integer.parseInt(num2.getText());/* num2对象调用getText()方法取得自己显示的文本字符串 */
        num3.setText("" + (n1 + n2));/* num3对象调用setText()方法设置自己的显示文本 */
        num1.setText("");
        /* 计算结束后清空num1,num2文本框里面的内容 */
        num2.setText("");
        // num3.setText(String.valueOf((n1+n2)));
        /* 字符串与任意类型的数据使用“+”连接时得到的一定是字符串，
         * 这里使用一个空字符串与int类型的数连接，这样就可以直接把(n1+n2)得到的int类型的数隐式地转换成字符串了，
         * 这是一种把别的基础数据类型转换成字符串的一个小技巧。
         * 也可以使用“String.valueOf((n1+n2))”把(n1+n2)的和转换成字符串
         */
    }
}