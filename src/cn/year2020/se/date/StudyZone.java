package cn.year2020.se.date;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/7/2 0002
 */
public class StudyZone {

    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // 北京
//        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));  // 设置北京时区
        bjSdf.setTimeZone(TimeZone.getTimeZone(ZoneId.of("+8"))); // 设置背景时区

        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));  // 设置东京时区

        SimpleDateFormat kenniyaSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
        kenniyaSdf.setTimeZone(TimeZone.getTimeZone(ZoneId.of("+3")));  // 设置肯尼亚时区

        SimpleDateFormat londonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 伦敦
        londonSdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));  // 设置伦敦时区

        System.out.println("毫秒数:" + date.getTime() + ", 北京时间:" + bjSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 东京时间:" + tokyoSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 肯尼亚时间:" + kenniyaSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 伦敦时间:" + londonSdf.format(date));
    }

    /**
     * @param date 当地时间
     * @param zoneId 时区
     * @return 时区的时间
     */
    public static String getDateTimeByZone(Date date, String zoneId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of(zoneId)));
        return simpleDateFormat.format(date);
    }
}
