package me.kaishun.剑指offer.重建二叉树;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution {
    public static void main(String[] args) {

    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {

        TreeNode treeNode = stackReconstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return treeNode;
    }

    private TreeNode stackReconstructBinaryTree(int[] pre, int pStart, int pEnd ,
                                            int[] in, int iStart, int iEnd) {
        //边界条件挺恶心的
        if(pStart>pEnd||iStart>iEnd){
            return null;
        }else{
            TreeNode root = new TreeNode(pre[pStart]);
            for (int i = iStart; i <=iEnd ; i++) {
                if(in[i]==pre[pStart]){
                    root.left=stackReconstructBinaryTree(pre,pStart+1,pStart+(i-iStart)
                            ,in, iStart, i-1);
                    root.right=stackReconstructBinaryTree(pre,pStart+(i-iStart)+1,pEnd
                            ,in,i+1,iEnd);
                    break;
                }
            }
            return root;
        }
    }

    /**
     * Definition for binary tree
     */
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
