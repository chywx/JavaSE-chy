package com2020.access.modifier1;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/5/26 0026
 */
public class TestOne {

    public static void main(String args[]) {

        ParentClass obj = new ParentClass();

        System.out.println(obj.a);
        System.out.println(obj.b);
        System.out.println(obj.c);
//		System.out.println(obj.d);     //d 不可见
    }
}
