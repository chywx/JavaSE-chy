package leetcode.editor.cn;//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// 👍 293 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class SolutionOfter64 {

    public static void main(String[] args) {
        SolutionOfter64 solution = new SolutionOfter64();
        System.out.println(solution.sumNums(5));
    }


    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        System.out.println(x);
        res += n;
        return res;
    }

    public int sumNums2(int n) {
        return n == 1 ? 1 : n + sumNums2(--n);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
