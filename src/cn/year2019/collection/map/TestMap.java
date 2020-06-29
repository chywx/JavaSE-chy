package cn.year2019.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {

    }


    @Test
    public void testHashtable() {
        Map<String, String> hashtable = new Hashtable<>();
        hashtable.put("aaa", "111");
        hashtable.put("bbb", "222");
        hashtable.put("ccc", "333");
        System.out.println(hashtable);
    }

    @Test
    public void testHashMap() {
        Map<String, String> map = new HashMap<>();
        map.put("aaa", "111");
        map.put("bbb", "222");
        map.put("ccc", "333");
        System.out.println(map);
    }

    /**
     * integer的hashcode就是当前值
     */
    @Test
    public void test1() {
        int i = 2 ^ 3;
        System.out.println(i);

        int hash = hash("aa");
        System.out.println(hash);


        System.out.println(0x7ff8000000000000L);
        Double d = 12.3d;
        System.out.println(d.hashCode());

        System.out.println("aa".hashCode());

        System.out.println("0x7FFFFFFF:" + 0x7FFFFFFF);
        System.out.println("MAX_VALUE:" + Integer.MAX_VALUE);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Test
    public void test2() {
        String string = "abc|cba|aaa";
//        System.out.println(string.replace("|",""));
        System.out.println(string.replaceAll("\\|", ""));
        String s = "\"abc\",\"aaa\"";
        System.out.println(s.replaceAll("\"", ""));
//        System.out.println(s.replaceAll("\\\"",""));
    }

}
