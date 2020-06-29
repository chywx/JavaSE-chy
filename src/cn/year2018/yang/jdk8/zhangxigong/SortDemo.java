package cn.year2018.yang.jdk8.zhangxigong;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortDemo {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        List<Long> numbers = Arrays.asList(
                1544608632755L,// 最大值
                1544584378000L,
                1542273570000L,
                1542273571000L//选中的
        );
        Long max = Collections.max(numbers, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o1 - o2);
            }
        });
//        Long max = Collections.max(numbers, new Comparator<Long>() {
//            @Override
//            public int compare(Long o1, Long o2) {
//                if (o1 == o2) {
//                    return 0;
//                } else if (o1 < o2) {
//                    return -1;
//                } else {
//                    return 1;
//                }
//            }
//        });
        System.out.println(max);
    }

}
