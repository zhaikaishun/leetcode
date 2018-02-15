package 剑指offer.链表中倒数第k个节点;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {

            return null;
    }

    public ListNode myFindKthToTail(ListNode head,int k) {
        // 总的节点数是多少
        int total=0;
        ListNode listNode = head;
        while(listNode!=null){
            total++;
            listNode = listNode.next;
        }
        // 倒数第k个就是正数第total-k+1个
        if(total-k<0){
            return null;
        }
        listNode = head;
        for (int i = 0; i <total-k ; i++) {
            listNode=listNode.next;
        }

        return listNode;
    }

}
