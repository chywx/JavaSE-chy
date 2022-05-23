package leetcode.editor.cn;//实现 strStr() 函数。
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1064 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution28 {

    public static void main(String[] args) {
        System.out.println("abc".indexOf("b"));
        System.out.println("abc".indexOf(""));

        System.out.println();
        Solution28 solution28 = new Solution28();
        int i = solution28.strStr("a", "a");
        System.out.println(">>>" + i);
    }

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        char[] haystackChars = haystack.toCharArray();
        char[] needleChars = needle.toCharArray();

        for (int i = 0; i < haystack.length() + 1 - needle.length(); i++) {
            int flat = 0;
            for (int j = 0; j < needle.length(); j++) {
                if (haystackChars[i + j] == needleChars[j]) {
                    flat++;
                }
            }
            if (flat == needle.length()) {
                return i;
            }
        }

        return -1;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
