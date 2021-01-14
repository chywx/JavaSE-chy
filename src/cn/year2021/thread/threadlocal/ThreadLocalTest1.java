package cn.year2021.thread.threadlocal;/**
 * @author chy
 * @date 2021/1/12 0012 下午 18:10
 * Description：
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/1/12 0012
 */
public class ThreadLocalTest1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            Runnable runnable = () -> {
                Date date = new Date(1000 * finalI);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                System.out.println(simpleDateFormat.format(date));
            };
            executorService.execute(runnable);
        }

    }

}
