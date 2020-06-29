package cn.year2019.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://blog.csdn.net/yiqiu3812/article/details/90904391
 * hashSet 无序插入
 * treeSet 自然排序和定制排序
 * linkedHashSet 插入顺序排序
 *
 * @author chy
 * @date 2019/11/12 0012
 */
public class TestSetSort {

    public static void main(String[] args) {
        Set<String> marketGroups = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        HashSet<String> strings1 = new HashSet<>();
        strings1.add("main");

        HashSet<String> strings2 = new HashSet<>();
        strings2.add("combo");

        HashSet<String> strings3 = new HashSet<>();
        strings3.add("goals");

        marketGroups.addAll(strings1);
        marketGroups.addAll(strings2);
        marketGroups.addAll(strings3);
        System.out.println(marketGroups);

        treeSet.addAll(strings1);
        treeSet.addAll(strings2);
        treeSet.addAll(strings3);
        System.out.println(treeSet);

        TreeSet<String> strings = new TreeSet<>();
        strings.add("main");
        strings.add("combo");
        strings.add("goals");
        System.out.println(strings);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("main");
        linkedHashSet.add("combo");
        linkedHashSet.add("goals");
        System.out.println(linkedHashSet);


    }

}
