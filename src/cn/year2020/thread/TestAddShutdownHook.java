package cn.year2020.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/6/22 0022
 */
public class TestAddShutdownHook {

    public static void main(String[] args) {
        // register shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("Do something in Shutdown Hook")));

        // sleep for some time
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println("Count: " + i + "...");
                TimeUnit.MILLISECONDS.sleep(1000);
            }
            List nullList = new ArrayList<>();
            System.out.println("Trying to print null list's first element: " + nullList.get(0).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
        System.out.println("Ready to exit.");

    }
}
