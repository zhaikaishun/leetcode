package 剑指offer.从头打印链表;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 注：链表用
 */
public class Solution {
    ArrayList<Integer> resultList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            resultList.add(listNode.val);
        }
        return resultList;
    }

    /**
     * 这个类一般用来代替链表
     */
    public class ListNode
    {
        int val;
        ListNode next;

        public ListNode(int x){
            val=x;
        }

    }
}
