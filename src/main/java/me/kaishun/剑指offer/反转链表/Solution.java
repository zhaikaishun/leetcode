package me.kaishun.剑指offer.反转链表;

import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class Solution {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.new ListNode(1);
        listNode.next=solution.new ListNode(2);
        listNode.next.next=solution.new ListNode(3);
        listNode.next.next.next=solution.new ListNode(4);
        ListNode listNode1 = solution.ReverseList(listNode);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    /**
     * 推荐做法: 时间复杂度o(n), 空间复杂度o(1)
     * @param head
     * @return
     */
    public ListNode ReverseList(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 最开始自己的想法，首先想到的就是栈
     * 时间复杂度o(n),空间复杂度o(n)
     * @param head
     * @return
     */
    public ListNode myReverseList(ListNode head) {
        Stack<ListNode> stackVal = new Stack<>();
        ListNode listNode = head;
        while (listNode!=null){
            stackVal.push(listNode);
            listNode=listNode.next;
        }
        ListNode listNode1 = new ListNode(stackVal.pop().val);
        ListNode p = listNode1;
        while (!stackVal.empty()){
            p.next=stackVal.pop();
            p=p.next;
        }
        p.next=null;
        return listNode1;
    }
}
