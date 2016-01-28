package com.zemo.easy.node.tree;

import com.zemo.util.TreeNode;

/**
 * @ClassName: InvertBinaryTree
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 1/28/16 20:55
 * @Description Invert a binary tree.
 *                4                      4
 *              /   \                  /   \
 *             2     7      to        7     2
 *            / \   / \              / \   / \
 *          1   3 6   9             9   6 3   1
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return root;
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        if (root.left != null) invertTree(root.left);
        if (root.right !=null) invertTree(root.right);
        return root;
    }
}
