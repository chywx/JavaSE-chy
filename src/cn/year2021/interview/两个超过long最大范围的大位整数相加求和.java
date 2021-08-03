package cn.year2021.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 两个超过long最大范围的大位整数 相加求和
 * "128764218354716235467......213649128374698127364871235423412341234"
 * "7152386581623584......213649128374412341234"
 *
 * 基本思路：
 * 先找出最长的字符串，切分出来左边多余的部分
 *
 * 之后两个字符串对其，for循环切分相加，如果超过10，然后10取模，标记下，下一次过来加一
 *
 * 最后将切分出来多余的部分拼接上刚才算出来的字符串
 */
public class 两个超过long最大范围的大位整数相加求和 {

    public static void main(String[] args) {

        String str1 = "198879826731";
        String str2 = "9826731";

        String longStr, shortStr;

        if (str1.length() > str2.length()) {
            longStr = str1;
            shortStr = str2;
        } else {
            longStr = str2;
            shortStr = str1;
        }

        int moreLength = longStr.length() - shortStr.length();
        String str = "";
        for (int i = 0; i < moreLength; i++) {
            str += 0;
        }
        shortStr = str += shortStr;
        System.out.println(shortStr);
        System.out.println(longStr);

        String[] split1 = longStr.split("");
        String[] split2 = shortStr.split("");

        List<Integer> list = new ArrayList<>();

        int tag = 0;

        for (int i = longStr.length() - 1; i >= 0; i--) {

            int sum = Integer.parseInt(split1[i]) + Integer.parseInt(split2[i]) + tag;
            System.out.println("sum:" + sum);

            if (sum >= 10) {
                tag = 1;
            } else {
                tag = 0;
            }

            sum = sum % 10;
            list.add(sum);
        }
        if (tag == 1) {
            list.add(tag);
        }

        Collections.reverse(list);
        System.out.println(list);
        System.out.println(Long.parseLong(str1) + Long.parseLong(str2));

    }

}
