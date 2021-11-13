package com.cevier.leetcode;

public class removeElementInList203 {

     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            while(head != null && head.val == val){
                ListNode delNode = head;
                head = head.next;
            }

            if (head == null)
                return null;

            ListNode pre = head;
            while (pre.next != null){
                ListNode cur = pre.next;
                if(cur.val == val){
                    pre.next = cur.next;
                }else {
                    pre = pre.next;
                }
            }
            return head;
        }
    }
    class Solution2 {
        public ListNode removeElements(ListNode head, int val) {
            if(head == null)
                return null;

//            ListNode rest = removeElements(head.next, val);
//            if(head.val == val)
//                return rest;
//            else{
//                head.next = rest;
//                return head;
//            }

            head.next = removeElements(head.next, val);
            return head.val == val ? head.next : head;
        }
    }
}
