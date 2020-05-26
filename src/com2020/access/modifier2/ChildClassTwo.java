package com2020.access.modifier2;

import com2020.access.modifier1.ParentClass;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/5/26 0026
 */
public class ChildClassTwo extends ParentClass {

    public static void main(String[] args) {
        // 由于不在同一个包中，default不可见
        ChildClassTwo obj = new ChildClassTwo();

        System.out.println(obj.a);
        System.out.println(obj.b);
//		System.out.println(obj.c);    // c不可见
//		System.out.println(obj.d);    // d不可见
    }

}
