package me.kaishun.剑指offer.二叉搜索树的后续遍历序列;

/**
 * 输入一个整数数组，
 * 判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */

/**
 * 第一想法： 感觉这没法判断啊, 后来仔细看题，这是一颗儿茶搜索树
 * 二叉搜索树定义如下：
 * 是一棵空树，或者是具有下列性质的二叉树：
 * 1. 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 2. 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 3. 它的左、右子树也分别为二叉排序树。
 */

/**
 已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
 1、确定root；
 2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
 3、遍历右子树，若发现有小于root的值，则直接返回false；
 4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
 */
public class Solution {

    public static void main(String[] args) {
        int[] ints = {4,6,7,5};
        System.out.println(new Solution().VerifySquenceOfBST(ints));
    }

    public boolean VerifySquenceOfBST(int [] sequence) {

        if(sequence==null || sequence.length==0){
            return false;
        }else{
            return stackVerifySBT(sequence,0,sequence.length-1);
        }
    }

    private boolean stackVerifySBT(int[] array, int start, int end) {
        if(start>=end){
            return true;
        }
        int endData = array[end];
        // 初始化splitIndex为end，这个很重要
        int splitIndex = end;
        // 找出分割的位置
        for (int i = start; i <=end ; i++) {
            if(array[i]>endData){
                splitIndex = i;
                break;
            }
        }
        // 判断右边是否有比endData小的，若比endData小，那么返回false
        for (int i = splitIndex; i <end ; i++) {
            if(array[i]<endData){
                return false;
            }
        }

        return stackVerifySBT(array,start,splitIndex-1) && stackVerifySBT(array,splitIndex,end-1);
    }
}
