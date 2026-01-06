package com.zemo.medium;

import com.zemo.util.ListNode;

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // l1  2   4   3

        // l2  5   6   4
        ListNode head = new ListNode(-1);
        ListNode result = head;
        int n = 0;
        while (l1 != null || l2 != null || n > 0) {

            if (l1 != null) {
                n += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n += l2.val;
                l2 = l2.next;
            }
            result.next = new ListNode(n % 10);
            result = result.next;
            n = n / 10;
        }
        return head.next;
    }

    public static void main(String[] args) {

    }

}
