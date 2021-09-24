package leetcode.editor.cn;//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 👍 650 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution144 {

    public static void main(String[] args) {
        Solution144 solution144 = new Solution144();
        List<Integer> integers = solution144.preorderTraversal(null);
        System.out.println(integers);

        UUID uuid = UUID.randomUUID();
        System.out.println(uuid);
        String s = uuid.toString().replaceAll("-", "");
        System.out.println(s);

        String replace = uuid.toString().replace("-", "");
        System.out.println(replace);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        add(root, integers);
        return integers;
    }

    public void add(TreeNode root, List<Integer> integers) {
        if (root == null) {
            return;
        }
        integers.add(root.val);
        add(root.left, integers);
        add(root.right, integers);
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)
