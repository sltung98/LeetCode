package org.adamtungleetcode.linkedlist;

import java.util.List;
import java.util.ListResourceBundle;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        System.out.println(new ReverseLinkedList().recursiveReverseList(listNode1).val);
    }
    public ListNode iterativeReverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public ListNode recursiveReverseList(ListNode head) {
        if (head == null) {
            return null;
        } else {
            return recursiveReverseListHelperFunction(null, head);
        }
    }
    private ListNode recursiveReverseListHelperFunction(ListNode prev, ListNode curr) {
        ListNode next = curr.next;
        curr.next = prev;
        if (next == null) {
            return curr;
        } else {
            return recursiveReverseListHelperFunction(curr, next);
        }
    }

}
