package com.cevier.leetcode.ReverseLinkedList;

public class ReverseLinkedList {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null)
                return head;
            ListNode curr = head;
            ListNode pre = null;
            while(curr != null){
                ListNode next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
            }
            return pre;
        }
    }

    class Solution2 {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null)
                return head;

            ListNode rest = reverseList(head.next);
            head.next.next = head;
            head.next = null;

            return rest;
        }

    }
}
