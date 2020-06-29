package cn.year2020.se.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/6/16 0016
 */
public class MatchChina {

    public static void main(String[] args) {
        String s = "<receiver_name>陈平<发信息>■</receiver_name><发信息>";
        String m = "<[\u4e00-\u9fa5]+>";
        Pattern pattern = Pattern.compile(m);

        Matcher ma = pattern.matcher(s);

        while (ma.find()) {
            System.out.println("find " + ma.group());
        }
    }

}
