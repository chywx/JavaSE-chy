package cn.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Dylan
 * @date: 2022/3/11 11:03
 */
public class CopyUtil {

    public static <T> T copyObject(Object source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        return JSONObject.parseObject(JSONObject.toJSONString(source), clazz);

    }

    public static <T> List<T> copyArray(Object source, Class<T> clazz) {
        if (source == null) {
            return null;
        }
        return JSONArray.parseArray(JSONObject.toJSONString(source), clazz);
    }

    public static <T> Set<T> copySet(Object source, Class<T> clazz) {
        List<T> ts = copyArray(source, clazz);
        return new HashSet<>(ts);
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("a", "b");
        System.out.println(JSONObject.toJSONString(strings));
//        List<String> strings = CopyUtil.copyArray("[\"aaa\"]", String.class);
        List<String> strings1 = JSONArray.parseArray(JSONObject.toJSONString(strings), String.class);
        System.out.println(strings1);
//        System.out.println(strings);
    }

}
