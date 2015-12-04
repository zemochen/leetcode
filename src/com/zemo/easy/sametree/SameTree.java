package com.zemo.easy.sametree;

import com.zemo.util.TreeNode;

/**
 * @ClassName: SameTree
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 11/17/14 23:23
 * @Description Given two binary trees, write a function to check if they are equal or not.
 *              Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if ((p == null || q == null)||(p.val != q.val))
            return false;
        else
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
