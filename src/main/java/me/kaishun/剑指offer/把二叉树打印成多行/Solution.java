package me.kaishun.剑指offer.把二叉树打印成多行;

import me.kaishun.工具类.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * 用个nlast和last来分层
 */
public class Solution {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();

        if(pRoot==null){
            return result;
        }

        LinkedList<TreeNode> queen = new LinkedList<>();
        queen.offer(pRoot);
        TreeNode last=pRoot;
        TreeNode nLast=null;

        while (!queen.isEmpty()){
            TreeNode poll = queen.poll();
            tempList.add(poll.val);
            if(poll.left!=null){
                queen.offer(poll.left);
                nLast = poll.left;
            }
            if(poll.right!=null){
                queen.offer(poll.right);
                nLast = poll.right;
            }
            //换行
            if(poll==last){
                result.add(tempList);
                tempList = new ArrayList<>();
                last=nLast;
            }

        }

        return result;

    }
}
