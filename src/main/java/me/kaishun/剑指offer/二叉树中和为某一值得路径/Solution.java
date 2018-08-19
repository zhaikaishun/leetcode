package me.kaishun.剑指offer.二叉树中和为某一值得路径;

import me.kaishun.工具类.TreeNode;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */

/*
  个人思路: 就是一个先序遍历，每到一个节点，加入到一个list中去，当到了一个叶子节点的时候，就判断这个list的值是否等于target
  遍历后，想父节点回寻的时候，list要去掉当前的子节点，但是有几个细节需要注意，子节点遍历了左边，如果发现左边是null，
  其实就是叶子节点了，不需要遍历右边了，否则会有重复的结果产生
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(12);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(7);
        int target = 22;
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> arrayLists = solution.FindPath(treeNode, target);
        for (ArrayList<Integer> arrayList : arrayLists) {
            System.out.println(arrayList.toString());
        }

    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null){
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> allResults = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> results = new ArrayList<>();
        preOrderRecur(root,allResults,results,0,target);
        return allResults;
    }
    /**
     * 先序遍历，找到叶子节点，就算是一个，否则，减去这一个
     * @param root
     * @param allResults
     * @param results
     * @param all
     * @param target
     */
    public static void preOrderRecur(TreeNode root, ArrayList<ArrayList<Integer>> allResults,ArrayList<Integer> results,int all,int target){
        if(root==null){ //说明是叶子节点
            if(all==target){
                ArrayList<Integer> cloneLists = new ArrayList<>(results);
                allResults.add(cloneLists);
            }
            return;
        }else{
            results.add(root.val);
            all+=root.val;
        }
        if(all<=target){
            preOrderRecur(root.left,allResults,results,all,target);
            if(root.left!=null){
                results.remove(results.size()-1);
            }
            if(root.left!=null){ // 左边是叶子节点，就不需要再遍历右边了，否则会有重复的
                preOrderRecur(root.right,allResults,results,all,target);
                if(root.right!=null){
                    results.remove(results.size()-1);
                }
            }

        }
    }



}
