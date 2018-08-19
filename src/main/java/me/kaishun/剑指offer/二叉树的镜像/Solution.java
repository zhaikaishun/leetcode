package me.kaishun.剑指offer.二叉树的镜像;

import me.kaishun.工具类.TreeNode;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 *
 */
/*二叉树的镜像定义：源二叉树
          8
        /  \
        6   10
       / \  / \
       5  7 9 11
        镜像二叉树
           8
         /   \
        10    6
        / \  / \
       11 9 7   5*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(8);
        treeNode.left=new TreeNode(6);
        treeNode.right=new TreeNode(10);
        solution.Mirror(treeNode);
    }

    public void Mirror(TreeNode root) {
        if(root==null){
            return;
        }else{
            TreeNode tmpNode;
            tmpNode = root.left;
            root.left = root.right;
            root.right = tmpNode;
            Mirror(root.left);
            Mirror(root.right);
        }
    }
}
