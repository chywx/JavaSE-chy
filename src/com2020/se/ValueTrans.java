package com2020.se;

import org.junit.Test;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/1/10 0010
 */
public class ValueTrans {

    public static void main(String[] args) {

    }

    @Test
    public void testStr(){
        String str = "aaa";
        System.out.println(str);
        StrF(str);
        System.out.println(str);
    }

    public void StrF(String str){
        str = "abc";
    }

    @Test
    public void testInt(){
        Integer integer = 111;
        System.out.println(integer);
        intF(integer);
        System.out.println(integer);
    }

    public void intF(Integer integer){
        integer = 123;
    }

    @Test
    public void testObj(){
        WolfDemo wolfDemo = new WolfDemo();
        wolfDemo.setId(1);
        wolfDemo.setName("aaa");
        System.out.println(wolfDemo);
        objF(wolfDemo);
        System.out.println(wolfDemo);
    }

    public void objF(WolfDemo wolfDemo){
        wolfDemo.setName("abc");
    }

}
