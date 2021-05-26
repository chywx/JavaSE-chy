package cn.year2021.classloader;/**
 * @author chy
 * @date 2021/5/14 0014 下午 17:03
 * Description：
 */

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/5/14 0014
 */
public class MyClassLoaderChecker {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        String path = "D:\\IdeaProjects\\sportbet\\api\\bet.api\\target\\classes\\com\\gbank\\betting\\utils\\";
        MyClassLoader m = new MyClassLoader(path, "myClassLoader");
        Class who = m.loadClass("PersonDemo");
        System.out.println(who);
        Object o = who.newInstance();
        System.out.println(o);

        Method say = who.getDeclaredMethod("say");
        Object invoke = say.invoke(o);
        System.out.println(invoke);

        Method[] methods = who.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            if (method.getName().equals("say")) {
                System.out.println(method.invoke(o));
            }
        }

    }

}
