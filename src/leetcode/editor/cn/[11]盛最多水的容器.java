package leetcode.editor.cn;//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 双指针 👍 4722 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution11 {

    public static void main(String[] args) {
        System.out.println(new Solution11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public int maxArea(int[] height) {

        int start = 0;
        int end = height.length - 1;

        int result = 0;
        while (start < end) {


            int h = height[start];
            if (height[end] < h) {
                h = height[end];
            }

            int r = h * (end - start);
            if (result < r) {
                result = r;
            }

            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }


        }

        return result;
    }

    public int maxArea2(int[] height) {

        int result = 0;

        for (int i = 0; i < height.length - 1; i++) {

            for (int j = i + 1; j < height.length; j++) {

                int h = height[i];
                if (height[j] < h) {
                    h = height[j];
                }
                int r = h * (j - i);
                if (result < r) {
                    result = r;
                }

            }
        }

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
