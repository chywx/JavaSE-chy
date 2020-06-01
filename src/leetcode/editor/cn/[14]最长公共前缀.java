package leetcode.editor.cn;//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {

    public static void main(String[] args) {
        String str[] = {"aa", "ab"};
        String s = new Solution14().longestCommonPrefix(str);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        String word = getMinLengthWord(strs);
        if (word.equals("")) {
            return "";
        }
        int index = 0;

        while (true) {
            if (index > word.length()) {
                for (String str : strs) {
                    if (!str.contains(word)) {
                        return word.substring(0, word.length() - 1);
                    }
                }
                return word;
            }
            String commonPrefix = word.substring(0, index);
            for (int i = 0; i < strs.length; i++) {
                if (!strs[i].startsWith(commonPrefix)) {
                    return commonPrefix.substring(0, commonPrefix.length() - 1);
                }
                if (i == strs.length - 1) {
                    index++;
                }
            }
        }

    }

    public String getMinLengthWord(String[] strs) {
        String word = null;
        int length = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < length) {
                length = str.length();
                word = str;
            }
        }
        return word;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
