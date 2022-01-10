package cn.year2022.demo;

import java.util.HashSet;
import java.util.Set;

public class Fantuan {

    public static void main(String[] args) {
        Fantuan fantuan = new Fantuan();
        fantuan.pring("好好学习，好好学习，天天向上");
        fantuan.pring("好好学学吧");
    }

    public void pring(String string) {
        // 用于去重操作
        Set<String> set = new HashSet<>();
        for (int i = 0; i < string.length() - 2; i++) {
            // 如果包含逗号，继续循环
            if (string.charAt(i) == ',' || string.charAt(i + 1) == ',' || string.charAt(i + 2) == ',') {
                continue;
            }
            // 判断 index1 == index2 && index2 != index3
            if (string.charAt(i) == string.charAt(i + 1) && string.charAt(i + 1) != string.charAt(i + 2)) {
                char[] carr = {string.charAt(i), string.charAt(i + 1), string.charAt(i + 2)};
                set.add(String.valueOf(carr));
                // 解决叠加情况
                i += 2;
            }
        }
        System.out.println("输入字符串\t" + string);
        System.out.println("AAB子串为\t" + set);
        System.out.println("AAB子串有\t" + set.size() + "种");
    }
}
