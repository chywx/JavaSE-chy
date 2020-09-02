package cn.year2020.dongyao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author chy
 * @date 2020/8/20 0020
 */
public class TestDemo {

    public static void main(String[] args) {
        List<Person> list = new ArrayList<Person>() {{
            add(new Person(3));
            add(new Person(22));
            add(new Person(13));
            add(new Person(11));
            add(new Person(34));
            add(new Person(21));
            add(new Person(21));
            add(new Person(31));
            add(new Person(11));
            add(new Person(13));
            add(new Person(51));
            add(new Person(3));
            add(new Person(11));
            add(new Person(3));
        }};
        // 统计出各个年龄的人数并打印，且按年龄排序，如下所示
        // 1→1
        // 2→1
        // 3→2

        Map<Integer, Integer> map = new TreeMap<>();
        for (Person person : list) {
            map.put(person.getAge(), map.getOrDefault(person.getAge(), 0) + 1);
        }
        map.entrySet().forEach(p -> System.out.println(p.getKey() + "→" + p.getValue()));

    }

}

class Person {

    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
