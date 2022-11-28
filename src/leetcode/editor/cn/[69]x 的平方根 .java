package leetcode.editor.cn;//给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
//
// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。 
//
// 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 4
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：x = 8
//输出：2
//解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x <= 231 - 1 
// 
// Related Topics 数学 二分查找 
// 👍 907 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution69 {

    public int mySqrt(int x) {

        int ret = 0;
        int len = (x + "").length() / 2;
        int val = 1;
        for (int i = 0; i < len - 1; i++) {
            val = val * 10;
        }
        System.out.println(val);
        for (int i = val; i <= x; i++) {
            System.out.println(i);
            if (i * i < x) {
                ret = i;
            } else if (i * i == x) {
                return i;
            } else {
                return ret;
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(1016064 * 1016064);
        System.out.println(8061297 * 8061297);
//        System.out.println(new Solution().mySqrt(18));
        System.out.println();
//                                                    1593901056
        System.out.println(new Solution69().mySqrt(2147483647));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
