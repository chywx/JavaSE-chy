package cn.year2021.interview.heyihong;

import java.util.HashMap;

/**
 * @author chy
 * @date 2021年08月03日 下午 16:00
 * //        输入: [[1,3],[2,6],[8,10],[15,18]]
 * //        输出: [[1,6],[8,10],[15,18]]
 * //        解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class 区间合并 {

    public static void main(String[] args) {



        HashMap<String, String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put("aa", "aa");
        stringStringHashMap.put("bb", "bb");
        stringStringHashMap.put("cc", "bb");
        System.out.println(stringStringHashMap);

        System.out.println(1 & 15);
        System.out.println(2 & 15);
        System.out.println(17 & 15);

        System.out.println();
        System.out.println(8 ^ 11);

        System.out.println();
        for (int i = 0; i < 100; i++) {
            System.out.println(i & 15);

        }

        System.out.println();
        for (int i = 0; i < 1000; i++) {
            int h;
            String key = i+"a";
            h = (h = key.hashCode()) ^ (h >>> 16);
            System.out.println(h + " - " + key.hashCode());
        }

    }

}
