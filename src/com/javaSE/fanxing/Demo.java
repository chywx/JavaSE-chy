package com.javaSE.fanxing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class A {
}

class B extends A {
}

class C extends B {
}

public class Demo<T, TT> {
    T value;

    TT value2;

    public TT getValue2() {
        return value2;
    }

    public void setValue2(TT value2) {
        this.value2 = value2;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public static <TTT> TTT f1(TTT t) {
        return t;
    }

    // 传递指定的A类型，对应的list可以进行对应的list应有的方法。
    public static void f2(List<A> list) {
        list.add(new A());
        System.out.println(list.size());
    }

    public static void f3(List<?> list) {
//		list.add(new A()); //当传入的是?通配符的话表示只能进行跟?无关的操作，类似于size方法，增加代码的可读性。
        System.out.println(list.size());
    }

    public static void f4(List<? extends B> listExtends) {
//		listExtends.add(new B());//不能进行写做操，因为是?,增加了可读性。
        System.out.println(listExtends.size());
    }

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        // 打印的判断为TRUE，因为泛型信息被擦除了。
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        System.out.println(l1.getClass() == l2.getClass());


        // 泛型擦除实例。
        List<String> listErasure = new ArrayList<String>() {
            // 直接初始化，这也是一种方式。直接传入一个collection。
            {
                add("aaa");
                add("bbb");
            }
        };
        listErasure.add("ccc");
        Class<? extends List> class1 = listErasure.getClass();
        Method method = class1.getMethod("add", Object.class);
        method.invoke(listErasure, 123);
        System.out.println(listErasure);


        Demo<String, Integer> demo = new Demo<String, Integer>();
        demo.setValue("string");
        System.out.println(demo.getValue());


        Demo<Integer, String> demo2 = new Demo<Integer, String>();
        demo2.setValue(100);
        System.out.println(demo2.getValue());


        System.out.println(f1(123));
//		List<A> listA = new ArrayList<A>();
//		List<B> listB = listA;//new ArrayList<B>();虽然B是A的子类，并不代表泛型之间也具备继承关系。


        ArrayList<A> listA = new ArrayList<A>();
        listA.add(new A());
        f3(listA); // 不对f3方法进行任何操作，是1.
        f2(listA); // 2对应的方法实现还进行了一次插入操作。
        f3(listA); // static ，对应的listA的集合数量是引用值。


        ArrayList<B> listB = new ArrayList<B>();
        listB.add(new B());
        f3(listB); // f3方法传递的是通配符?，不能进行add操作。


        // <? extends T> 和 <? super T>
        List<? extends B> listExtends = new ArrayList<B>();
//		listExtends.add(new A()); 全部编译错误。因为使用的是extends，丧失了写的操作能力。跟f3方法一样，是未知类型，只是确定了里面对象的范围。是B的子类。
//		listExtends.add(new B());
//		listExtends.add(new C());

        // 能进行对B以及B的子类操作。这是super的神奇之处。
        List<? super B> listSuper = new ArrayList<B>();
//		listSuper.add(new A());//会编译错误。
        listSuper.add(new B());
        listSuper.add(new C());


        // 没毛病。
        List<B> listBS = new ArrayList<B>();
        listBS.add(new B());
        f4(listBS);

    }
}
