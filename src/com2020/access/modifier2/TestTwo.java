package com2020.access.modifier2;

import com2020.access.modifier1.ParentClass;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/5/26 0026
 */
public class TestTwo {

    public static void main(String[] args) {
        // 由于不在同一个包中，也没有继承，所以仅public可见
        ParentClass obj = new ParentClass();

        System.out.println(obj.a);
//		System.out.println(obj.b);     // b 不可见
//		System.out.println(obj.c);     // c 不可见
//		System.out.println(obj.d);     // d 不可见
    }

}
