package com.zemo.easy.node.tree;

import com.zemo.util.TreeNode;

/**
 * @ClassName: MaximumDepth
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 1/13/16 21:15
 * @Description Given a binary tree, find its maximum depth.
 *              The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if (root != null) {
            int maxLeft = maxDepth(root.left);
            int maxRight = maxDepth(root.right);
            if (maxLeft > maxRight) {
                return maxLeft + 1;
            } else {
                return maxRight + 1;
            }
        } else {
            return 0;
        }
    }

}
