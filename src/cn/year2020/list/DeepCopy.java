package cn.year2020.list;

import com.alibaba.fastjson.JSONArray;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/9/2 0002
 */
public class DeepCopy {

    public static void main(String[] args) {
        List<Teacher> list = new ArrayList<>();
        Teacher teacher = new Teacher();
        teacher.setId("aaa");
        list.add(teacher);
        System.out.println(list);

        System.out.println(">>> test json");
        String string = JSONArray.toJSONString(list);
        List<Teacher> teacherList = JSONArray.parseArray(string, Teacher.class);
        teacherList.get(0).setId("bbb");
        System.out.println(list);
        System.out.println(teacherList);

        System.out.println(">>> test new");
        List<Teacher> newList = new ArrayList<>(list);
        newList.get(0).setId("ccc");
        System.out.println(list);
        System.out.println(newList);

        System.out.println(">>> test stream");
        List<Teacher> collect = list.stream().collect(Collectors.toList());
        collect.get(0).setId("ddd");
        System.out.println(list);
        System.out.println(collect);

        System.out.println(">>> test Collections copy");
        List<Teacher> copyList = new ArrayList<>();
        for (Teacher barMenu : list) {
            copyList.add(barMenu);
        }

        Collections.copy(copyList, list);
        copyList.get(0).setId("fff");
        System.out.println(list);
        System.out.println(copyList);

        System.out.println(">>> test io");
        List<Teacher> serList = deepCopy(list);
        list.get(0).setId("ggg");
        System.out.println(list);
        System.out.println(serList);


    }

    /**
     * 对集合进行深拷贝
     * 注意需要岁泛型类进行序列化（实现serializable）
     */
    public static <T> List<T> deepCopy(List<T> src) {
        try (ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(byteOut);
        ) {
            outputStream.writeObject(src);
            try (ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
                ObjectInputStream inputStream = new ObjectInputStream(byteIn);
            ) {
                return (List<T>) inputStream.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }


}
