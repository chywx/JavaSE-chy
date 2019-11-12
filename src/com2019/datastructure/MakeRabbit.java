package com2019.datastructure;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author chy
 * @date 2019/9/15 0015
 */
public class MakeRabbit {

    public static List<Rabbit> ss = new ArrayList<>();

    public static void main(String[] args) {

        int month = 10;
        Rabbit rabbit = getRabbit(month);
        Rabbit allRabbits = getAllRabbits(rabbit);

        Object o = JSONObject.toJSON(allRabbits);
        System.out.println(o.toString());
//        System.out.println(allRabbits);

        getCount(allRabbits);
        System.out.println(month+1+"个月,兔子数量："+ss.size());
    }

    public static Rabbit getRabbit(int month){
        Rabbit rabbit = new Rabbit();
        rabbit.setAge(month);
        return rabbit;
    }

    public static Rabbit getAllRabbits(Rabbit rabbit){

        if(rabbit.getAge()<2)
            return rabbit;
        if(rabbit.getAge()>=2){

            List<Rabbit> rabbits = new ArrayList<>();
            for (int i = 2; i <= rabbit.getAge(); i++) {
                Rabbit r = new Rabbit();
                r.setAge(i-2);
                getAllRabbits(r);
                rabbits.add(r);
            }
            rabbit.setLists(rabbits);
        }

        return rabbit;
    }
    public static void getCount(Rabbit rabbit){
        ss.add(rabbit);
        if (!CollectionUtils.isEmpty(rabbit.getLists())){
            System.out.println(rabbit.getLists().size());
            for (Rabbit list : rabbit.getLists()) {
                getCount(list);
            }
        }
    }
}

class Rabbit{
    private int age;
    private List<Rabbit> lists;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Rabbit> getLists() {
        return lists;
    }

    public void setLists(List<Rabbit> lists) {
        this.lists = lists;
    }


    @Override
    public String toString() {
        return "Rabbit{" +
                "age=" + age +
                ", lists=" + lists +
                '}';
    }
}