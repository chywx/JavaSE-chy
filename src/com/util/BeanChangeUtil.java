package com.util;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class BeanChangeUtil<T> {

    public String contrastObj(Object oldBean, Object newBean) {
        StringBuilder str = new StringBuilder();
        T pojo1 = (T) oldBean;
        T pojo2 = (T) newBean;
        // 通过反射获取类的Class对象
        Class clazz = pojo1.getClass();
        // 获取类型及字段属性
        Field[] fields = clazz.getDeclaredFields();
//        return jdk8Before(fields, pojo1, pojo2, str,clazz);
        return jdk8OrAfter(fields, pojo1, pojo2, str,clazz);
    }

    public String jdk8Before(Field[] fields,T pojo1,T pojo2,StringBuilder str,Class clazz){
        int i = 1;
        try {
            for (Field field : fields) {
                if(field.isAnnotationPresent(PropertyMsg.class)){
                    PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                    // 获取对应属性值
                    Method getMethod = pd.getReadMethod();
                    Object o1 = getMethod.invoke(pojo1);
                    Object o2 = getMethod.invoke(pojo2);
                    if (o1 == null || o2 == null) {
                        continue;
                    }
                    if (!o1.toString().equals(o2.toString())) {
                        str.append(i + "、" + field.getAnnotation(PropertyMsg.class).value() + ":" + "修改前=>" + o1 + ",修改后=>" + o2 + "\n");
                        i++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str.toString();
    }

    public String jdk8OrAfter(Field[] fields, T pojo1, T pojo2, StringBuilder str, Class clazz){
        final int[] i = {1};
        Arrays.asList(fields).forEach(f -> {
            if(f.isAnnotationPresent(PropertyMsg.class)){
                try {
                    PropertyDescriptor pd = new PropertyDescriptor(f.getName(), clazz);
                    // 获取对应属性值
                    Method getMethod = pd.getReadMethod();
                    Object o1 = getMethod.invoke(pojo1);
                    Object o2 = getMethod.invoke(pojo2);
                    if (o1 == null || o2 == null) {
                        return;
                    }
                    if (!o1.toString().equals(o2.toString())) {
                        str.append(i[0] + "、" + f.getAnnotation(PropertyMsg.class).value() + ":" + "修改前=>" + o1 + "\t修改后=>" + o2 + "\n");
                        i[0]++;
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        return str.toString();
    }

}

