package cn.year2021.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chy
 * @date 2021年06月22日 下午 18:41
 * dfs(num)
 * 遍历数字1~num，找到能被自己整除的因子mulNum，那么[mulNum, num/mulNum]就是一种结果， 并往下继续dfs(num/mulNum)得到num/mulNum的可能情况并添加到返回结果。
 *
 * 剪枝点：
 *
 * 为了避免重复，没必要从1开始遍历，而是从上一次的mulNum开始遍历，这样保证mulNum后续dfs的过程是递增的，所以不会出现重复。
 * 遍历终点没必要为num， 而是num的开根号， 因此最大情况2^32的开根号结果为2^16次方=65536，是可接受范围。
 */
public class Test254 {

    public static void main(String[] args) {
        Test254 test254 = new Test254();
        System.out.println(test254.getFactors(100));
    }

    public List<List<Integer>> getFactors(int n) {
        return dfs(2, n);
    }

    List<List<Integer>> dfs(int start, int num) {
        if (num == 1) {
            return new ArrayList<>();
        }

        int qNum = (int) Math.sqrt(num);
        List<List<Integer>> result = new ArrayList<>();
        for (int mulNum = start; mulNum <= qNum; mulNum++) {
            if (num % mulNum == 0) {
                List<Integer> simpleList = new ArrayList<>();
                simpleList.add(mulNum);
                simpleList.add(num / mulNum);
                result.add(simpleList);
                // 检查mulNum能怎么拆
                List<List<Integer>> nextLists = dfs(mulNum, num / mulNum);
                for (List<Integer> list : nextLists) {
                    list.add(mulNum);
                    result.add(list);
                }
            }
        }
        return result;
    }

}
