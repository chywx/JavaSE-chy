package com2018.util.test;

import com2018.util.BeanChangeUtil;
import com2018.util.PropertyMsg;

public class TestChange {

    public static void main(String[] args) {
        TestChange u1 = new TestChange("我是谁", "ok", 30, "刘德华");
        TestChange u2 = new TestChange("我在哪", "no", 20, "郭富城");
        BeanChangeUtil<TestChange> t = new BeanChangeUtil<>();
        String str = t.contrastObj(u1, u2);
        if (str.equals("")) {
            System.out.println("未有改变");
        } else {
            System.out.println(str);
        }
    }

    public TestChange() {
    }

    public TestChange(String about, String lock, Integer age, String name) {
        this.about = about;
        this.lock = lock;
        this.age = age;
        this.name = name;
    }

    @PropertyMsg("关于")
    private String about;

    private String lock;

    @PropertyMsg("年龄")
    private Integer age;

    @PropertyMsg("姓名")
    private String name;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
