package org.adamtungleetcode.linkedlist;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode list1Third = new ListNode(4);
        ListNode list1Second = new ListNode(2, list1Third);
        ListNode list1 = new ListNode(1, list1Second);
        ListNode list2Third = new ListNode(4);
        ListNode list2Second = new ListNode(3, list2Third);
        ListNode list2 = new ListNode(1, list2Second);
        ListNode mergedList = new MergeTwoSortedLists().mergeTwoLists(list1, list2);
        ListNode curr = mergedList;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = new ListNode();
        ListNode curr = mergedList;
        while (list1 != null || list2 != null) {
            if (list1 == null) {
                curr.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                curr.next = list1;
                list1 = list1.next;
            } else if (list1.val <= list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        return mergedList.next;
    }
}
