package me.kaishun.剑指offer.复杂链表的复制;

import me.kaishun.工具类.RandomListNode;

/*
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 测试用例:
    {1,2,3,4,5,3,5,#,2,#}
    对应输出应该为:
    {1,2,3,4,5,3,5,#,2,#}
 */

/*
 *分析，此题目的难度在于指针的引用，以及如何循环,刚开始还做不出来
 */
public class Solution {

    public static void main(String[] args) {

    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) {
            return null;
        }
        // 1. 构建A->A'->B->B'->C->C'->D->D'->E->E'->F->F'
        // 先构建next
        RandomListNode currentNode;
        currentNode = pHead;
        while (currentNode!=null){
            RandomListNode copyNode = new RandomListNode(currentNode.label);
            copyNode.next = currentNode.next;
            currentNode.next = copyNode;
            currentNode = copyNode.next;
        }
        //再构建random
        currentNode = pHead;
        while (currentNode!=null){
//            currentNode.next.random = currentNode.random;  //这里是有问题的，如果这样，随机链表又是指向了ABCDEF中的一个，而不是A'B'..等
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            //这里判断null纯粹是为了这个测试用例，测试用例中有null的
            currentNode = currentNode.next==null?null:currentNode.next.next;
        }
        //再拆分
        RandomListNode originListNode = pHead;
        RandomListNode copyListNode=pHead.next;  // 这个定死了不要动

        //这里是有点绕
        while (originListNode!=null){
            RandomListNode copyNode = originListNode.next;
            originListNode.next = copyNode.next;
            copyNode.next = originListNode.next==null?null:originListNode.next.next;
            originListNode = originListNode.next;
        }


        // copyListNode即为复制的，head还是原来的
        return copyListNode;
    }
}
