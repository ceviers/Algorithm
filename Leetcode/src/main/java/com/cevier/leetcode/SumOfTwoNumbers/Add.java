package com.cevier.leetcode.SumOfTwoNumbers;


import com.cevier.leetcode.ReverseLinkedList.ReverseLinkedList;
import org.w3c.dom.NodeList;

import java.util.List;

public class Add {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode result = null;
            ListNode cur1 = l1;
            ListNode cur2 = l2;
            int overflow = 0;
            while(cur1 != null || cur2 != null){
                if(cur1 == null)
                    cur1 = new ListNode(0,cur1);
                if(cur2 == null)
                    cur2 = new ListNode(0,cur2);

                int temp = cur1.val + cur2.val + overflow;
                result = new ListNode(temp % 10, result);
                overflow = temp / 10;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            if(overflow > 0)
                result = new ListNode(overflow, result);
            if(result == null)
                return result;
            return reverseList(result);
        }

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

    public ListNode getList(int[] arr){
        ListNode list = null;
        for (int a: arr) {
            list = new ListNode(a, list);
        }
        return list;
    }
}
