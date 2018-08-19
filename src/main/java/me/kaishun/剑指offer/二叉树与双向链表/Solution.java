package me.kaishun.剑指offer.二叉树与双向链表;

import me.kaishun.工具类.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

/*
  个人思路： 首先想到的是中序遍历，放在一个队列中，然后将这个队列依次弹出，按照顺序进行左右的链接
 */
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        inOrderRecur(pRootOfTree,queue);
        if(queue.isEmpty()){
            return pRootOfTree;
        }
        pRootOfTree = queue.poll();  // 定死的根节点
        TreeNode pre = pRootOfTree;
        //初始化第一个的left为null
        pre.left = null;
        TreeNode cur = null;
        while (!queue.isEmpty()){
            cur = queue.poll();
            //前后的连接
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        //最后尾部给个null
        pre.right = null;
        return pRootOfTree;
    }
    public void inOrderRecur(TreeNode node, Queue<TreeNode> queue){

        if(node==null){
            return;
        }
        inOrderRecur(node.left,queue);
        queue.add(node);
        inOrderRecur(node.right,queue);

    }
    //还有其他更好方法，我应该去了解的，但是目前先稍微看看

}
