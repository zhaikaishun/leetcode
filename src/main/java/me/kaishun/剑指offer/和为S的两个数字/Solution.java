package me.kaishun.剑指offer.和为S的两个数字;

import java.util.ArrayList;
/*
## 题目描述
输入一个递增排序的数组和一个数字S，
在数组中查找两个数，是的他们的和正好是S，
如果有多对数字的和等于S，输出两个数的乘积最小的。
## 输出描述:
对应每个测试案例，输出两个数，小的先输出

 */
public class Solution {
    /*
    1. 加逼定理，两个指针
    2. 周长一定，肯定越正方形，面积越大
     */
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i=0;
        int j = array.length-1;
        while (i<j){
            if((array[i]+array[j])<sum){
                i++;
            }else if((array[i]+array[j])==sum){
                list.add(array[i]);
                list.add(array[j]);
                return list;
            }else{
                j--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] ints = {1,2,4,7,11,15};
        int sum = 15;
        ArrayList<Integer> integers = FindNumbersWithSum(ints, sum);
        System.out.println(integers.toString());
    }
}
