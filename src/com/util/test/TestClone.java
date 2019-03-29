package com.util.test;


import com.util.CloneUtils;

public class TestClone {

    public static void main(String[] args) throws Exception{
        TestClone demo = new TestClone();
        demo.setName("chy");
        demo.setAge(10);
        TestClone clone = CloneUtils.springClone(demo);
        System.out.println(demo.equals(clone));


        TestClone demo2 = new TestClone();
        BeanUtils.copyProperties(demo,demo2);
        System.out.println(demo);
        System.out.println(demo2);

        TestClone demo3 = new TestClone();
        CloneUtils.springClone(demo,demo3);
        System.out.println(demo3);

        TestClone demo4 = new TestClone();
        CloneUtils.commonsClone(demo,demo4);
        System.out.println(demo4);

        TestClone common1 = CloneUtils.commonsClone(demo);
        System.out.println(common1);

    }

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestClone{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
