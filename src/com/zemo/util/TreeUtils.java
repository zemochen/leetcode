package com.zemo.util;

import java.util.Random;

/**
 * @ClassName: TreeUtils
 * @author: superzemo
 * @email: zeming.chen@dmall.com
 * @Date 2022/12/6
 * @Description
 */
public class TreeUtils {


    public static TreeNode generateTree(int depth) {
        if (depth == 0) {
            return null;
        }
        Random random = new Random();
        TreeNode head = new TreeNode(random.nextInt(depth * 10) + 1);
        head.left = generateTree(depth - 1);
        head.right = generateTree(depth - 1);

        return head;
    }

    // 用于获得树的层数
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }


    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) {
            return;
        }
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) {
            return;
        }
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }


    public static void show(TreeNode root) {
        if (root == null) {
            System.out.println("EMPTY!");
        }
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    public static void preOrderPrint(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + ",");
        preOrderPrint(head.left);
        preOrderPrint(head.right);
    }

    public static void inOrderPrint(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderPrint(head.left);
        System.out.print(head.val + ",");
        inOrderPrint(head.right);
    }

    //后续遍历
    public static void backOrderPrint(TreeNode head) {
        if (head == null) {
            return;
        }
        backOrderPrint(head.left);
        backOrderPrint(head.right);
        System.out.print(head.val + ",");
    }

    // 递归函数，用于还原二叉树
    public static TreeNode restoreTree(int[] preorder, int start, int end) {
        // 如果已经没有元素可以处理，则停止递归
        if (start > end) {
            return null;
        }
        // 创建一个新节点，值为前序遍历序列中的第一个元素
        TreeNode node = new TreeNode(preorder[start]);
        // 找到左子树和右子树的边界
        int leftEnd = start;
        while (leftEnd <= end && preorder[leftEnd] <= node.val) {
            leftEnd++;
        }
// 递归生成左子树和右子树
        node.left = restoreTree(preorder, start + 1, leftEnd - 1);
        node.right = restoreTree(preorder, leftEnd, end);
// 返回当前节点
        return node;
    }

    public static void dsf() {
    }

    public static void bfs() {

    }

    public static void main(String[] args) {
        Random random = new Random(2);

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt());
            System.out.println(random.nextBoolean());
        }

        TreeNode randomTree = generateTree(3);

        show(randomTree);
        preOrderPrint(randomTree);
        System.out.println();
        inOrderPrint(randomTree);
        System.out.println();
        backOrderPrint(randomTree);
        System.out.println();

        System.out.println("============还原二叉树:");
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        // 还原二叉树
        TreeNode root = restoreTree(preorder, 0, preorder.length - 1);
        show(root);
    }

}
