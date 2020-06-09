package leetcode.editor.cn;//实现一个基本的计算器来计算一个简单的字符串表达式的值。
//
// 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格 。 
//
// 示例 1: 
//
// 输入: "1 + 1"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: " 2-1 + 2 "
//输出: 3 
//
// 示例 3: 
//
// 输入: "(1+(4+5+2)-3)+(6+8)"
//输出: 23 
//
// 说明： 
//
// 
// 你可以假设所给定的表达式都是有效的。 
// 请不要使用内置的库函数 eval。 
// 
// Related Topics 栈 数学


//leetcode submit region begin(Prohibit modification and deletion)v
class Solution224 {

    public static void main(String[] args) {
        Solution224 solution = new Solution224();
//        System.out.println(solution.calculate("2-(5-6)"));
//        System.out.println(solution.calculate("(5-(1+(5)))"));
//        System.out.println(solution.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(solution.calculate("(5-(1+(5)))"));
//        System.out.println(solution.calculate("1-(2+3-(4+(5-(1-(2+4-(5+6))))))"));
    }

    public int calculate(String s) {
        String string = s.replace(" ", "");

        while (string.indexOf(")") != -1) {
            int index = string.indexOf(")");
            String substring = string.substring(0, index);
            int lastIndexOf = substring.lastIndexOf("(");
            String realStr = substring.substring(lastIndexOf + 1);
            int calc = calc(realStr);
            string = string.substring(0, lastIndexOf) + calc + string.substring(index + 1);

        }
        int calc = calc(string);
        return calc;
    }

    int calc(String realStr) {
        String replace = realStr.replace("--", "+");
        replace = replace.replace("+", " ").replace("-", " -");
//        System.out.println(replace);
        int index = realStr.indexOf("(");
        if (index != -1) {
            replace = realStr.replace("(", "").replace(")", "");
            return Integer.parseInt(replace);
        }
        int sum = 0;
        for (String s : replace.split(" ")) {
            if (s == null || "".equals(s)) {
                continue;
            }
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
