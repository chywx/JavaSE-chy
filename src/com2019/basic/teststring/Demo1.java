package com2019.basic.teststring;

/**
 * 功能描述
 *
 * @author chy
 * @date 2019/10/17 0017
 */
public class Demo1 {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        String str = "111";
        String a = "111";
        String str2 = a + "";
//        false
        System.out.println(str == str2);
        StringBuilder stringBuilder = new StringBuilder("111");
//        false
        System.out.println(stringBuilder.toString() == str2);
//        true
        System.out.println(stringBuilder.toString().equals(str2));
    }
}
