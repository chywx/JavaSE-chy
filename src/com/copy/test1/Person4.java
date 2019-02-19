package com.copy.test1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person4 implements Serializable {
	public static void main(String[] args) throws CloneNotSupportedException, ClassNotFoundException, IOException {
		Son4 son = new Son4(10);
		Person4 person1 = new Person4("大海", son);
		//通过序列化方法实现深拷贝
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(person1);
        oos.flush();
        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        Person4 person2=(Person4)ois.readObject();
        person1.setSon4Name("小海");
        person1.getSon4().setAge(12);
        System.out.println(person1.toString());
        System.out.println(person2.toString());
	}

	public Person4(String son4Name, Son4 son4) {
		super();
		this.son4Name = son4Name;
		this.son4 = son4;
	}

	private String son4Name;
	private Son4 son4;

	public String getSon4Name() {
		return son4Name;
	}

	public void setSon4Name(String son4Name) {
		this.son4Name = son4Name;
	}



	public Son4 getSon4() {
		return son4;
	}

	public void setSon4(Son4 son4) {
		this.son4 = son4;
	}

	@Override
	public String toString() {
		return "Person4 [son4Name=" + son4Name + ", son4=" + son4 + "]";
	}


	

}

class Son4 implements Serializable {
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

	public Son4(int age) {
		super();
		this.age = age;
	}

}