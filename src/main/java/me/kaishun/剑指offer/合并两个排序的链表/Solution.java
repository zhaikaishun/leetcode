package me.kaishun.剑指offer.合并两个排序的链表;

import me.kaishun.工具类.ListNode;

/**
 * Created by Administrator on 2018/2/15.
 */
public class Solution {

    /**
     * 挺好的，不过这题可不是我做的
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        //新建一个头节点，用来存合并的链表。
        ListNode head=new ListNode(-1);
        head.next=null;
        ListNode root=head;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                head.next=list1;
                head=list1;
                list1=list1.next;
            }else{
                head.next=list2;
                head=list2;
                list2=list2.next;
            }
         }
        //把未结束的链表连接到合并后的链表尾部
        if(list1!=null){
            head.next=list1;
        }
        if(list2!=null){
            head.next=list2;
        }
        // 返回root的next
        return root.next;
    }
}
