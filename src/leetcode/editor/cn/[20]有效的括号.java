package leetcode.editor.cn;//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution20 {

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("{[]}"));
        System.out.println(solution20.isValid("([)]"));
        System.out.println(solution20.isValid("}{"));
        System.out.println(solution20.isValid("null"));
    }

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '(') {
                stack.push(')');
            } else {
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                if (c != pop) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Set<Character> keySet = map.keySet();
        char[] chars = s.toCharArray();
        List<Character> characters = new ArrayList<>();
        for (char c : chars) {
            if (keySet.contains(c)) {
                characters.add(c);
            } else {
                if (characters.size() - 1 < 0) {
                    return false;
                }
                Character character = characters.remove(characters.size() - 1);
                Character mapChar = map.get(character);
                if (mapChar.equals(c)) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return characters.size() == 0 ? true : false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
