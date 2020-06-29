package cn.year2019.datastructure.tree;

public class Test2 {
    public static void main(String[] args) {
        int[] a = {62, 88, 58, 47, 35, 73, 51, 99, 37, 93};
        for (int i = 0; i < a.length; i++) {
            System.out.println("第" + i + "次");
            generateBinaryTree(a[i]);
        }

    }

    static BinaryTree newTree = new BinaryTree();

    /**
     * 全局变量，存放查找到的关键字所在的父节点
     */
    static BinaryTree parentNode = new BinaryTree();

    /**
     * 二叉排序树
     *
     * @param bt     待查询的二叉排序树
     * @param key    查找关键字
     * @param parent 指向bt的双亲，其初始调用值为null
     * @return 查找成功返回true，并将树节点赋值给全局变量result，查找失败返回false
     */
    public static boolean serachBinaryTree(BinaryTree bt, int key, BinaryTree parent) {
        if (bt == null || bt.data == 0) { // 树节点不存在，返回
            parentNode = parent;
            return false;
        } else if (key == bt.data) { // 查找成功
            parentNode = bt;
            return true;
        } else if (key < bt.data) { // 关键字小于根节点查找左子树
            return serachBinaryTree(bt.lchild, key, bt);
        } else { // 关键字大于根节点查找右子树
            return serachBinaryTree(bt.rchild, key, parent);
        }
    }

    /**
     * 生成二叉树
     *
     * @param key
     * @return
     */
    public static boolean generateBinaryTree(int key) {
        BinaryTree binaryTree;
        if (!serachBinaryTree(newTree, key, null)) {
            binaryTree = new BinaryTree();
            binaryTree.data = key;
            binaryTree.lchild = binaryTree.rchild = null;
            if (null == parentNode) {// 不存在，证明是父节点，将binaryTree指向bt成为新的根节点
                newTree = binaryTree;
            } else if (key < parentNode.data) { // 当key小于子根节点，插入为左孩子
                parentNode.lchild = binaryTree;
            } else { // 当key大于子根节点，插入为右孩子
                parentNode.rchild = binaryTree;
            }
            preOrderTraverse(newTree);
            return true;
        } else {
            System.out.println("该节点已存在");
        }

        return false;
    }

    /**
     * 中序遍历打印线索二叉树
     *
     * @param t
     */
    static void preOrderTraverse(BinaryTree t) {
        if (null == t || t.data == 0) {
            return;
        }
        if (t.lchild != null) {
            preOrderTraverse(t.lchild); // 中序遍历左子树
        }
        if (t.data != 0) {
            System.out.println("[" + t.data + "]"); // 显示当前节点的数据
        }

        if (t.rchild != null) {
            preOrderTraverse(t.rchild); // 最后遍历右子树
        }
    }
}
