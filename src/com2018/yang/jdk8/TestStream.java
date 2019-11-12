package com2018.yang.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestStream {
    public static void main(String[] args) {

        Random random = new Random();
        List<Student> list = new ArrayList<Student>() {
            {
                for (int i = 0; i < 10; i++) {
                    add(new Student("student" + i, random.nextInt(50) + 50));
                }
            }
        };
        System.out.println(list);
    }

}


class Student {
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
