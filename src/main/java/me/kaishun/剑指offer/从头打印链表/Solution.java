package me.kaishun.剑指offer.从头打印链表;

import me.kaishun.工具类.ListNode;

import java.util.ArrayList;

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
}
