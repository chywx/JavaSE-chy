package cn.year2021.bet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chy
 * @date 2021年10月19日 上午 10:38
 */
public class RegexTest {

    private static final String REGEX_TABLE_ALIAS = "^([A-Za-z0-9._()&'\\- ]|[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ])+$";

    public static void main(final String[] args) {
        final String string = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa!";
        final Pattern pattern = Pattern.compile(REGEX_TABLE_ALIAS);
        final Matcher matcher = pattern.matcher(string);
        final boolean result = matcher.find();
        System.out.println(result);
    }

}
