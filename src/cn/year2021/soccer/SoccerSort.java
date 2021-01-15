package cn.year2021.soccer;/**
 * @author chy
 * @date 2021/1/14 0014 下午 16:59
 * Description：
 */

import com.alibaba.fastjson.JSONObject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 功能描述
 * 要求输出结果：["0:0","1:0","2:0","3:0","4:0","0:1","1:1","2:1","3:1","4:1","0:2","1:2","2:2","3:2","4:2","0:3","1:3","2:3","3:3","4:3","0:4","1:4","2:4","3:4","4:4"]
 *
 * @author chy
 * @date 2021/1/14 0014
 */
public class SoccerSort {

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

        strings.sort((p1, p2) -> {
            int i = p1.split(":")[1].compareTo(p2.split(":")[1]);
            if (i == 0) {
                return p1.split(":")[0].compareTo(p2.split(":")[0]);
            }
            return i;
        });
        System.out.println(JSONObject.toJSONString(strings));

        strings.sort((p1, p2) -> {
            int i = p1.split(":")[0].compareTo(p2.split(":")[0]);
            if (i == 0) {
                return p1.split(":")[1].compareTo(p2.split(":")[1]);
            }
            return i;
        });
        System.out.println(JSONObject.toJSONString(strings));

    }

}