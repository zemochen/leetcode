package com.zemo.easy.node.list;

import com.zemo.util.ListNode;

/**
 * @ClassName: DeleteNode
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 1/14/16 21:50
 * @Description Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class DeleteNode {

    public void deleteNode(ListNode node) {
        if  (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
