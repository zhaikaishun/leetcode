package me.kaishun.剑指offer.删除链表中重复的结点;

import me.kaishun.工具类.ListNode;

/**
 * 题目描述
 在一个排序的链表中，存在重复的结点，
 请删除该链表中重复的结点，重复的结点不保留(注意)，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        ListNode listNode8 = new ListNode(5);

//        ListNode listNode = new ListNode(1);
//        ListNode listNode2 = new ListNode(1);
//        ListNode listNode3 = new ListNode(1);
//        ListNode listNode4 = new ListNode(1);
//        ListNode listNode5 = new ListNode(1);
//        ListNode listNode6 = new ListNode(1);
//        ListNode listNode7 = new ListNode(2);
//        ListNode listNode8 = new ListNode(2);
        listNode.next=listNode2;listNode2.next=listNode3;listNode3.next=listNode4;
        listNode4.next=listNode5;listNode5.next=listNode6; listNode6.next = listNode7;
//        listNode7.next = listNode8;
        Solution solution = new Solution();
        ListNode listNode1 = solution.deleteDuplication(listNode);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null) { // 只有0个或1个结点，则返回
            return pHead;
        }

        ListNode deleteNode = null;//用来记录重复节点
        ListNode newNode = new ListNode(-1);newNode.next = pHead;//新建一个节点，因为第一个也可能被删除，为了避免空指针
        ListNode preNode = newNode; //移动的节点
        ListNode nextNode = pHead;

        while (nextNode!=null && nextNode.next!=null){
            if (nextNode.val!=nextNode.next.val) {
                preNode = preNode.next;
                nextNode=nextNode.next;
            }else {
                deleteNode = nextNode;
                nextNode = nextNode.next;
                while (nextNode!=null&&nextNode.val==deleteNode.val){
                    nextNode = nextNode.next;
                }
                preNode.next = nextNode;
            }
        }
        return newNode.next;
    }
}
