package com.zemo.easy.link;

import com.zemo.util.ListNode;

/**
 * @ClassName: RemoveNode
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 1/14/16 23:24
 * @Description Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
public class RemoveNode {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        } else {
            head.next = removeElements(head.next, val);
        }
        return head.val == val ? head.next : head;
    }
}
