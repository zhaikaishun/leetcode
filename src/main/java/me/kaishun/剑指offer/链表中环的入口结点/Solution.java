package me.kaishun.剑指offer.链表中环的入口结点;

import me.kaishun.工具类.ListNode;

/**
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Solution {

    // 如图
    /*
     两个指针同时从A出发，一个运动速度为2，一个运动速度为1
     他们肯定会在某一点相遇，设k步后相遇，例如在C点相遇，那么慢的运动了ABC,为k， 快的为ABCBC，为2k
     ABCBC的路程减去ABC的路程，就是环的路程 为k， 所以A到B的路程为n-k. B到c的距离为k-(n-k) = 2k-n.
     c到b的距离为 k-(2k-n) = n-k 刚好等于A到B的距离
     那么所以此时将运动为2的重新移动到A点，然后以速度1来跑，当两者相遇的点，就是入口的点
     如果不是环形的话，运动快的那个点肯定会碰到null

     图片参考
     https://github.com/zhaikaishun/blog_img/blob/master/blog/%E5%88%A4%E6%96%AD%E5%8C%85%E5%90%AB%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8%E5%B9%B6%E4%B8%94%E6%89%BE%E5%87%BA%E5%85%A5%E5%8F%A3/%E7%8E%AF%E5%BD%A2%E9%93%BE%E8%A1%A8.png
     */
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        ListNode fast = pHead;
        ListNode slow = pHead;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null || fast.next==null){
            return null;
        }
        fast = pHead;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
