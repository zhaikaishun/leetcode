package me.kaishun.剑指offer.对称的二叉树;

import me.kaishun.工具类.TreeNode;

/**
 * 题目描述
 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。

 刚开始的思路：
 思路1： 遍历吧，没的说，首先是保证左右两边的val一致，其次遍历分别保证一致，要所有的都为true才行
  思路2： 直接遍历，将镜像打出来，然后判断镜像和本身是不是相同，判断相不相同需要在前中后三种遍历中随便满足其中两个即可
 */
public class Solution {

    public static void main(String[] args) {
        //测试用例: {8,6,6,5,7,7,5} 应该返回true

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
        System.out.println(new Solution().isSymmetrical(root));

    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot==null){
            return true;
        }
        return isEquls(pRoot.left,pRoot.right);
    }

    private boolean isEquls(TreeNode left, TreeNode right) {
        if(left==null&&right==null){
            return true;
        }else if(left!=null&&right!=null){
            // 这是很容易错的一点，注意最后一个是left.left,right.right 即左边的左，等于右边的右
            return (left.val==right.val) && isEquls(left.left,right.right) && isEquls(left.right,right.left);
        }else {
            return false;
        }
    }

    /*
    * 感觉这题的价值在于这个
    *
    *
    * */

/*
     * DFS使用stack来保存成对的节点
     * 1.出栈的时候也是成对成对的 ，
                1.若都为空，继续；
                2.一个为空，返回false;
                3.不为空，比较当前值，值不等，返回false；
     * 2.确定入栈顺序，每次入栈都是成对成对的，如left.left， right.right ;left.rigth,right.left
     */
//    boolean isSymmetricalDFS(TreeNode pRoot)
//    {
//        if(pRoot == null) return true;
//        Stack<TreeNode> s = new Stack<>();
//        s.push(pRoot.left);
//        s.push(pRoot.right);
//        while(!s.empty()) {
//            TreeNode right = s.pop();//成对取出
//            TreeNode left = s.pop();
//            if(left == null && right == null) continue;
//            if(left == null || right == null) return false;
//            if(left.val != right.val) return false;
//            //成对插入
//            s.push(left.left);
//            s.push(right.right);
//            s.push(left.right);
//            s.push(right.left);
//        }
//        return true;
//    }
}
