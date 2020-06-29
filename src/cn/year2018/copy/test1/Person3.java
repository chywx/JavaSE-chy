package cn.year2018.copy.test1;

public class Person3 implements Cloneable {
    public static void main(String[] args) throws CloneNotSupportedException {
        Son3 son1 = new Son3(10);
        Person3 person1 = new Person3("大海", son1);
        Person3 person2 = (Person3) person1.clone();
        person2.setSon2Name("小海");
        person2.getSon3().setAge(12);//修改对应的引用对象的值。
        System.out.println(person1);
        System.out.println(person2);
    }

    public Person3(String son2Name, Son3 son3) {
        super();
        this.son2Name = son2Name;
        this.son3 = son3;
    }

    private String son2Name;
    private Son3 son3;

    public String getSon2Name() {
        return son2Name;
    }

    public void setSon2Name(String son2Name) {
        this.son2Name = son2Name;
    }

    public Son3 getSon3() {
        return son3;
    }

    public void setSon3(Son3 son3) {
        this.son3 = son3;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person3 clone = (Person3) super.clone();
        clone.setSon3((Son3) clone.getSon3().clone());
        return clone;
    }

    @Override
    public String toString() {
        return "Person3 [son2Name=" + son2Name + ", son3=" + son3 + "]";
    }

}

class Son3 implements Cloneable {
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

    public Son3(int age) {
        super();
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}