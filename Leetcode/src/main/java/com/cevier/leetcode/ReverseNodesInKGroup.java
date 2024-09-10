package com.cevier.leetcode;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/">K 个一组翻转链表</a>
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            nodes.add(head);
            head = head.next;
        }

        if (nodes.size() < k) {
            return nodes.get(0);
        }

        ListNode[] array = nodes.toArray(new ListNode[0]);
        for (int i = 0; i < array.length / k; i++) {
            for (int j = 0; j < k / 2; j++) {
                ListNode tmp = array[i * k + j];
                array[i * k + j] = array[(i + 1) * k - 1 - j];
                array[(i + 1) * k - 1 - j] = tmp;
            }
        }

        for (int i = 0; i < array.length - 1; i++) {
            array[i].next = array[i + 1];
        }
        array[array.length - 1].next = null;

        return array[0];
    }

    public ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode node3 = head.next.next;
        node1.next = null;
        node2.next = node1;
        if (node3 == null) {
            return node2;
        }
        while (node3.next != null) {
            node1 = node2;
            node2 = node3;
            node3 = node3.next;
            node2.next = node1;
        }
        node3.next = node2;
        return node3;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode reverse = new ReverseNodesInKGroup().reverse(listNode);
        ListNode reverse2 = new ReverseNodesInKGroup().reverse(new ListNode(1, new ListNode(2)));
        ListNode reverse3 = new ReverseNodesInKGroup().reverse(new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(listNode, 4));
    }



}
