package com2019.collection.list;

import com2018.chy.design.decorator.Person;
import com2018.javaSE.fanxing.Demo;
import com2019.basic.teststring.Demo1;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author chy
 * @date 2019/11/29 0029
 */
public class TestList {

    public static void main(String[] args) {

        List<String> strrs = new ArrayList<>();
        strrs.add(null);
        System.out.println(null == strrs);
        System.out.println(strrs.isEmpty());




        chy:
        for(;;){
            System.out.println(123);
            break chy;
        }
        List<Demo1> list = new ArrayList<>();
        Demo1 demo1 = new Demo1();
        demo1.setName("aaa");

        Demo1 demo2 = new Demo1();
        demo2.setName("bbb");


        list.add(demo1);
        list.add(demo2);

        Demo1 demo11 = null;
        demo11 = demo2;
        System.out.println(list.indexOf(demo11));

        System.out.println(Boolean.valueOf("true"));
        System.out.println(Boolean.valueOf("false"));
        System.out.println(Boolean.valueOf("tru"));
    }

}
