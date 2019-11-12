package com2018.copy.test1;

public class Person {
    public static void main(String[] args) {
        Son s = new Son(10);
        Person p1 = new Person("大海", s);
        Person p2 = new Person(p1);
        p1.setSonName("小海");
        p1.getSon().setAge(12);
        System.out.println("p1:" + p1);// p1:Person [sonName=小海, son=Son [age=10]]
        System.out.println("p2:" + p2);// p2:Person [sonName=大海, son=Son [age=10]]

    }

    private String sonName;
    private Son son;

    // 自定义拷贝函数
    public Person(Person person) {
        this.sonName = person.sonName;
        this.son = person.son;
    }

    public Person(String sonName, Son son) {
        super();
        this.sonName = sonName;
        this.son = son;
    }

    public String getSonName() {
        return sonName;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }

    @Override
    public String toString() {
        return "Person [sonName=" + sonName + ", son=" + son + "]";
    }

}

class Son {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Son(int age) {
        super();
        this.age = age;
    }

    @Override
    public String toString() {
        return "Son [age=" + age + "]";
    }

}