package me.kaishun.剑指offer.按之字形顺序打印二叉树;
import me.kaishun.工具类.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 *
 * 刚开始思路
 * 1. 首先得知道最基本的宽度遍历，就是用队列而已
 * 2. 其次要怎么得到这个每层的遍历，一般按照层遍历就是价格last和nlast
 * 3. 对于偶数的就反转一下
 * 3. 最后要得到每个
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 不怎么好的思路
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> tempLists = new ArrayList<>();
        if(pRoot==null){
            return result;
        }

        TreeNode last=pRoot;
        TreeNode nlast=null;
        //用来标记行数的奇偶性，如果偶数，就需要进行反转
        int i = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();


        queue.offer(pRoot);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            tempLists.add(poll.val);
            if(poll.left!=null){
                queue.offer(poll.left);
                nlast = poll.left;
            }
            if(poll.right!=null){
                queue.offer(poll.right);
                nlast = poll.right;
            }
            if(poll==last){
                if(i%2==0){
                    Collections.reverse(tempLists);
                }
                i++;
                result.add(tempLists);
                tempLists = new ArrayList<>();
                last=nlast;
            }

        }


        return result;
    }
}
