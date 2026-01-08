package com.zemo.medium;

import com.zemo.util.ListNode;

public class PartitionList_86 {


    public ListNode partition(ListNode head, int x) {

        ListNode less = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        ListNode p1 = less;
        ListNode p2 = greater;
        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode tmp = p.next;
            p.next = null;
            p = tmp;

        }
        p1.next = greater.next;
        return less.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{1, 4, 3, 2, 5, 2});

        PartitionList_86 solution = new PartitionList_86();
        var res = solution.partition(head, 3);
        System.out.println(res);

    }
}
