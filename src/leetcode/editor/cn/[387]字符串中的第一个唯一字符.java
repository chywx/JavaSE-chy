package leetcode.editor.cn;//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 哈希表 字符串 
// 👍 224 👎 0


import java.util.LinkedHashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution387 {

    public static void main(String[] args) {
        Solution387 solution387 = new Solution387();
        System.out.println(solution387.firstUniqChar("leetcode"));
        System.out.println(solution387.firstUniqChar("loveleetcode"));
        System.out.println(solution387.firstUniqChar(""));
    }

    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            Integer orDefault = map.getOrDefault(c, 0);
            map.put(c, orDefault + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
