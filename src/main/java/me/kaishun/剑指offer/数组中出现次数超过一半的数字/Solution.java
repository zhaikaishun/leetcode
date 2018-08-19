package me.kaishun.剑指offer.数组中出现次数超过一半的数字;

/**
 * 题目描述
 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */

/*
 思考： 最开始想到的，肯定就是类似于hash表的方式。但是时间复杂度0(n)，空间复杂度o(n)
 进阶题目还有   n/k，出现次数超过n/k，找到他

 参考程序员面试参考指南
 只要不相同两两想消除的方式

 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array==null || array.length==0){
            return 0;
        }
        int pre = array[0];
        int preCount=1;
        for (int i = 1; i < array.length; i++) {
            if (preCount==0) {
                pre = array[i];
                preCount = 1;
                continue;
            }
            if(array[i]==pre){
                preCount++;
            }else{
                preCount--;
            }
        }
        //再判断是不是大于1/2
        int realNum=0;
        for (int i : array) {
            if (i==pre) {
                realNum++;
            }
        }
        if(realNum>(array.length/2)){
            return pre;
        }
        return 0;
    }
}
