package me.kaishun.剑指offer.树的子结构;

import me.kaishun.工具类.TreeNode;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 *
 * 注： 题目不清晰，此题因该是B的结构和A的结构在前序遍历的时候一致
 */
public class Solution {



    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        // 只要有一个为空，那么就返回false
        if(root1==null||root2==null){
            result =  false;
        }else{
            //如果能找到root2的根节点
            if(root1.val==root2.val){
                result = checkContains(root1,root2);
            }
            //如果找不到，递归遍历root1的左节点，去判断是否包含root2
            if(!result){
                result = HasSubtree(root1.left,root2);
            }
            //如果找不到，递归遍历root1的右节点，去判断是否包含root2
            if(!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }
    public boolean checkContains(TreeNode node1, TreeNode node2){
        //如果Tree2已经遍历完了都能对应的上，返回true
        if(node2==null){
            return true;
        }
        //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        if(node1==null){
            return false;
        }
        //如果其中有一个点没有对应上，返回false
        if(node1.val!=node2.val){
            return false;
        }else{
            //如果根节点对应的上，那么就分别去子节点里面匹配
            return checkContains(node1.left,node2.left) && checkContains(node1.right,node2.right);
        }
    }
}
