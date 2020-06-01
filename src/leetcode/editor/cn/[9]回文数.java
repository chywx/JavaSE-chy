package leetcode.editor.cn;//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution9 {

    public static void main(String[] args) {
//        System.out.println(new Solution9().isPalindrome(123));
//        System.out.println(new Solution9().isPalindrome(121));
//        System.out.println(new Solution9().isPalindrome(-123));
//        System.out.println(new Solution9().isPalindrome(0));
//        System.out.println(new Solution9().isPalindrome(1221));
//        System.out.println(new Solution9().isPalindrome(12321));
//        System.out.println(new Solution9().isPalindrome(123321));
//        System.out.println(new Solution9().isPalindrome(123421));

    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String string = String.valueOf(x);

        char[] chars = string.toCharArray();
        int len = chars.length / 2;
        for (int i = 0; i < len; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
