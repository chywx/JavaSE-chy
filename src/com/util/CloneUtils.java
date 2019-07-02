package com.util;

import org.springframework.beans.BeanUtils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用该工具类，bean需要有get set，Android的写法一般由于代码量是不写的。
 */
public class CloneUtils {
    // 可以实现深克隆
    public static <T> T chyClone(Object obj, Class<T> cla) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        return cla.cast(ois.readObject());
    }

    // spring 浅克隆，返回新的对象，不需要new
    public static <T> T springClone(T t) throws Exception {
        T target = (T) t.getClass().newInstance();
        BeanUtils.copyProperties(t, target);
        return target;
    }

    // spring 浅克隆，传入target对象
    public static void springClone(Object object, Object target) {
        BeanUtils.copyProperties(object, target);
    }

    // commons 浅克隆，返回新的对象，不需要new
    public static <T> T commonsClone(T t) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T target = (T) t.getClass().newInstance();
        org.apache.commons.beanutils.BeanUtils.copyProperties(target, t);
        return target;
    }

    // commons 浅克隆，返回传入的target对象
    public static void commonsClone(Object object, Object target) throws InvocationTargetException, IllegalAccessException {
        org.apache.commons.beanutils.BeanUtils.copyProperties(target, object);
    }


}