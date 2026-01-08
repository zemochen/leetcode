package com.zemo.util;

/**
 * @ClassName: ListNode
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 1/14/16 21:48
 * @Description ${TODO}
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public static ListNode  createLinkedList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (ListNode p = this; p != null; p = p.next) {
            s.append(p.val).append(",");
        }

        return s.substring(0, s.length()-1);
    }
}