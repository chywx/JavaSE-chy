package com2020.access.modifier1;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/5/26 0026
 */
public class ChildClassOne extends ParentClass {

    public static void main(String[] args) {
        ChildClassOne obj = new ChildClassOne();

        System.out.println(obj.a);
        System.out.println(obj.b);
        System.out.println(obj.c);
//		System.out.println(obj.d);      // d不可见

        // 即使使用多台，也不能访问
        ParentClass parentClass = new ChildClassOne();
        System.out.println(parentClass.a);
        System.out.println(parentClass.b);
        System.out.println(parentClass.c);
//		System.out.println(parentClass.d);      // d不可见
    }

}
