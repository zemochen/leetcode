package com.zemo.easy.symmetrictree;

import com.zemo.util.TreeNode;

/**
 * @ClassName: SymmertricTree
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 11/24/14 21:42
 * @Description Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *              For example, this binary tree is symmetric:
 *               1
 *              / \
 *             2   2
 *            / \ / \
 *           3  4 4  3
 *              But the following is not:
 *              1
 *             / \
 *            2   2
 *             \   \
 *             3    3
 */
public class SymmertricTree {
    public boolean isSymmetric(TreeNode root) {

        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }else if (root.left != null && root.right != null) {
            return isMirro(root.left, root.right);
        } else {
            return false;
        }

    }

    public boolean isMirro(TreeNode left, TreeNode right) {
        if (left.val == right.val) {
            if (left.left == null && left.right == null && right.left == null && right.right == null)
                return true;
            else
                return isMirro(left.left, right.right) && isMirro(left.right, right.left);
        }else
            return false;
    }
    public static void main(String[] args) {

    }
}
