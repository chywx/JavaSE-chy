package cn.year2019.thread.obj;

import org.junit.Test;

/**
 * 功能描述
 *
 * @author chy
 * @date 2019/11/28 0028
 */
public class ObjectMethodTest {

    private static Object obj = new Object();

    public static void main(String[] args) {

    }

    @Test
    public void test1(){
        Object o = new Object();
        synchronized (obj){
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
