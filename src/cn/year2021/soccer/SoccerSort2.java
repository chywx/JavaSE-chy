package cn.year2021.soccer;/**
 * @author chy
 * @date 2021/1/14 0014 下午 16:59
 * Description：
 */

import com.alibaba.fastjson.JSONObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述 不符合要求
 *
 * @author chy
 * @date 2021/1/14 0014
 */
public class SoccerSort2 {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(
            "0:0",
            "1:0",
            "2:0",
            "3:0",
            "4:0",
            "0:1",
            "1:1",
            "2:1",
            "3:1",

            "4:1",
            "0:2",
            "1:2",
            "2:2",
            "3:2",
            "4:2",
            "0:3",
            "1:3",
            "2:3",

            "3:3",
            "4:3",
            "0:4",
            "1:4",
            "2:4",
            "3:4",
            "4:4"
        );
        System.out.println(strings);

        Collections.shuffle(strings);

        System.out.println(strings);

        System.out.println(JSONObject.toJSONString(strings));

        Collections.sort(strings, (e1, e2) -> {
            String[] split1 = e1.split(":");
            String[] split2 = e2.split(":");
            int compare1 = Integer.compare(Integer.valueOf(split1[0]), Integer.valueOf(split2[0]));
            if (compare1 != 0) {
                return compare1;
            }
            int compare2 = Integer.compare(Integer.valueOf(split1[1]), Integer.valueOf(split2[1]));
            if (compare2 != 0) {
                return compare2;
            }
            return 0;
        });

        System.out.println(strings);

    }

}