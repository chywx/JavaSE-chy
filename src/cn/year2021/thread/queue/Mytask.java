package cn.year2021.thread.queue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author: Dylan
 * @date: 2022/6/27 15:29
 */
public class Mytask {

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println("TimerTask当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                }
            }
        };
        Timer timer = new Timer();
        long delay = 0;
        long period = 1000;
        timer.schedule(timerTask, delay, period);

    }
}
