package com.cevier.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/">合并 K 个升序链表</a>
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = null;
        ListNode tail = null;
        ListNode minNode = null;
        int minIdx = 0;
        boolean flag = false;
        while (true) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    minNode = lists[i];
                    minIdx = i;
                    flag = true;
                }
            }
            if (flag) {
                flag = false;
                if (head == null) {
                    head = minNode;
                    tail = head;
                } else {
                    tail.next = minNode;
                    tail = minNode;
                }
                lists[minIdx] = minNode.next;
            } else {
                break;
            }
        }

        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode[] a = new ListNode[1];
        a[0] = node;
        ListNode node1 = new MergeKSortedLists().mergeKLists(a);
    }


}
