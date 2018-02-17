package 剑指offer.从上往下打印二叉树;

import java.util.ArrayList;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

/**
 * 介绍，按照宽度优先遍历即可
 */
public class Solution {
    /**
     * 使用队列即可完成，具体原理代码很好理解
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> results = new ArrayList<>();
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        if(root==null){
            return results;
        }
        treeNodes.add(root);
        while (treeNodes.size()>0){
            TreeNode removeTreeNode = treeNodes.remove(0);
            results.add(removeTreeNode.val);
            if(removeTreeNode.left!=null){
                treeNodes.add(removeTreeNode.left);
            }
            if(removeTreeNode.right!=null){
                treeNodes.add(removeTreeNode.right);
            }
        }

        return results;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
