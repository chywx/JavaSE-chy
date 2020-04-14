package com2018.jdk18.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分组
 *
 * @author chy
 * @date 2020/2/19 0019
 */
public class Student {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student("six", 12, "Math", "Tim", 86D);
        Student student2 = new Student("six", 12, "English", "Tim", 84D);
        Student student3 = new Student("six", 12, "Chinese", "Tim", 83D);
        Student student1s = new Student("six", 12, "Math", "Rick", 84D);
        Student student2s = new Student("six", 12, "English", "Rick", 95D);
        Student student3s = new Student("six", 12, "Chinese", "Rick", 83D);
        students.add(student1);
        students.add(student1s);
        students.add(student2);
        students.add(student2s);
        students.add(student3);
        students.add(student3s);

        Student student4 = new Student("five", 11, "Math", "Jack", 78D);
        Student student5 = new Student("five", 11, "English", "Jack", 97D);
        Student student6 = new Student("five", 11, "Chinese", "Jack", 68D);
        Student student4s = new Student("five", 11, "Math", "Sam", 67D);
        Student student5s = new Student("five", 11, "English", "Sam", 93D);
        Student student6s = new Student("five", 11, "Chinese", "Sam", 92D);
        students.add(student4);
        students.add(student4s);
        students.add(student5);
        students.add(student5s);
        students.add(student6);
        students.add(student6s);

        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getName));

        for (String s : collect.keySet()) {

            List<Student> ss = collect.get(s);
            System.out.println(ss);

            List<String> stringSet = ss.stream().map(p -> p.getAge() + "").collect(Collectors.toList());
            String join = String.join(",", stringSet);
            System.out.println(join);
        }
    }

    //学生年级
    private String grade;
    //学生年龄
    private Integer age;
    //参加的科目
    private String subject;
    //名字
    private String name;
    //科目成绩
    private Double mark;

    public String getGrade() {
        return grade;
    }

    public Student() {
    }

    public Student(String grade, Integer age, String subject, String name, Double mark) {
        this.grade = grade;
        this.age = age;
        this.subject = subject;
        this.name = name;
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
            "grade='" + grade + '\'' +
            ", age=" + age +
            ", subject='" + subject + '\'' +
            ", name='" + name + '\'' +
            ", mark=" + mark +
            '}';
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }
}
