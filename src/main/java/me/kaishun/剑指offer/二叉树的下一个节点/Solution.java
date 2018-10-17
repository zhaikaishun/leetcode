package me.kaishun.剑指offer.二叉树的下一个节点;

import java.util.ArrayList;

/**
 * 题目描述
 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。


 最开始思路： 就是一个中序遍历，遍历到指定的节点后便可以，那么首先在于找到root节点，这种方法应该不是最优的

 更优思路： 参考左程云152或者牛客网

 */
public class Solution {

    public static void main(String[] args) {

    }

    public ArrayList<TreeLinkNode> nodeLists = new ArrayList<>();

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode curNode = pNode;// 将当前的pNode保存一下
        TreeLinkNode rootNode = getRootNode(pNode);
        inOrderRecur(rootNode);
        for (int i = 0; i < nodeLists.size(); i++) {
            if(nodeLists.get(i)==curNode && (i+1)<nodeLists.size()){
                return nodeLists.get(i+1);
            }
        }
        return null;
    }

    private void inOrderRecur(TreeLinkNode head) {
        if(head==null){
            return;
        }
        inOrderRecur(head.left);
        nodeLists.add(head);
        inOrderRecur(head.right);

    }

    private TreeLinkNode getRootNode(TreeLinkNode pNode) {
        while (pNode!=null){
            if(pNode.next==null){
                return pNode;
            }else {
                pNode = pNode.next;
            }
        }
        return null;
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null; //这个就是父节点

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

}
