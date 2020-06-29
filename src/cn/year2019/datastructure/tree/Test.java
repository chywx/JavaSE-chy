package cn.year2019.datastructure.tree;

public class Test {
    public static void main(String[] args) {
        // 主要是表达查询，所以手动构造一棵二叉排序树
        BinaryTree binaryTree1 = new BinaryTree();
        binaryTree1.data = 62;

        BinaryTree binaryTree2 = new BinaryTree();
        binaryTree1.lchild = binaryTree2;
        binaryTree2.data = 58;

        BinaryTree binaryTree3 = new BinaryTree();
        binaryTree2.lchild = binaryTree3;
        binaryTree3.data = 47;

        BinaryTree binaryTree4 = new BinaryTree();
        binaryTree3.lchild = binaryTree4;
        binaryTree4.data = 35;

        BinaryTree binaryTree5 = new BinaryTree();
        binaryTree4.rchild = binaryTree5;
        binaryTree5.data = 37;

        BinaryTree binaryTree6 = new BinaryTree();
        binaryTree3.rchild = binaryTree6;
        binaryTree6.data = 51;

        BinaryTree binaryTree7 = new BinaryTree();
        binaryTree1.rchild = binaryTree7;
        binaryTree7.data = 88;

        BinaryTree binaryTree8 = new BinaryTree();
        binaryTree7.lchild = binaryTree8;
        binaryTree8.data = 73;

        BinaryTree binaryTree9 = new BinaryTree();
        binaryTree7.rchild = binaryTree9;
        binaryTree9.data = 99;

        BinaryTree binaryTree10 = new BinaryTree();
        binaryTree9.lchild = binaryTree10;
        binaryTree10.data = 93;

        boolean search = serachBinaryTree(binaryTree1, 33, null);
        System.out.println(search == true ? "查找成功" + parentNode.data : "查找失败");
    }

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
}
