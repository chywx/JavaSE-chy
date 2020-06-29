package cn.year2020.se;

import java.util.Formatter;
import java.util.Locale;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/14 0014
 */
public class lIXinDate {

    public static void main(String[] args) {
        System.out.println(ms2HMS(17654321));
        System.out.println(HMS2ms("4:54:14"));
    }

    public static String ms2HMS(long millisecond) {
        if (millisecond <= 0 || millisecond >= 24 * 60 * 60 * 1000) {
            return "00:00";
        }
        long totalSeconds = millisecond / 1000;
        long seconds = totalSeconds % 60;
        long minutes = (totalSeconds / 60) % 60;
        long hours = totalSeconds / 3600;
        StringBuilder stringBuilder = new StringBuilder();
        Formatter mFormatter = new Formatter(stringBuilder, Locale.getDefault());
        if (hours > 0) {
            return mFormatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
        } else {
            return mFormatter.format("%02d:%02d", minutes, seconds).toString();
        }
    }

    public static Long HMS2ms(String HMS) {
        String[] split = HMS.split(":");
        Integer h = Integer.parseInt(split[0]);
        Integer m = Integer.parseInt(split[1]);
        Integer s = Integer.parseInt(split[2]);
        Long ms = 0L;
        if (h != 0) {
            ms += h * 60 * 60 * 1000;
        }
        if (m != 0) {
            ms += m * 60 * 1000;
        }
        if (s != 0) {
            ms += s * 1000;
        }
        return ms;
    }


}
