package com2018.copy.test1;

public class Person2 implements Cloneable {
    public static void main(String[] args) throws CloneNotSupportedException {
        Son2 son1 = new Son2(10);

        Person2 person1 = new Person2("大海", son1);
        Person2 person2 = (Person2) person1.clone();
        person2.setSon2Name("小海");
        person2.getSon2().setAge(12);
        System.out.println(person1);
        System.out.println(person2);
    }

    public Person2(String son2Name, Son2 son2) {
        super();
        this.son2Name = son2Name;
        this.son2 = son2;
    }

    private String son2Name;
    private Son2 son2;

    public String getSon2Name() {
        return son2Name;
    }

    public void setSon2Name(String son2Name) {
        this.son2Name = son2Name;
    }

    public Son2 getSon2() {
        return son2;
    }

    public void setSon2(Son2 son2) {
        this.son2 = son2;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Person2 [son2Name=" + son2Name + ", son2=" + son2 + "]";
    }

}

class Son2 {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Son2 [age=" + age + "]";
    }

    public Son2(int age) {
        super();
        this.age = age;
    }

}