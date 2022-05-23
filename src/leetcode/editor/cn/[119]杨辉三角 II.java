package leetcode.editor.cn;//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 👍 335 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(2));
    }

    public List<Integer> getRow(int rowIndex) {
//        int numRows = rowIndex + 1;
//        List<List<Integer>> lists = new ArrayList<>();
//        for (int i = 0; i < numRows; i++) {
//            List<Integer> list = new ArrayList<>();
//            for (int j = 0; j <= i; j++) {
//
//                if (j == 0 || j == i) {
//                    list.add(1);
//                } else {
//                    List<Integer> integers = lists.get(i - 1);
//                    list.add(integers.get(j - 1) + integers.get(j));
//                }
//            }
//            lists.add(list);
//        }
//        return lists.get(rowIndex);

        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
