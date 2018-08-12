package me.kaishun.剑指offer.旋转数组中的最小数字;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/2/14.
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转,
 * 该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * 注意的坑，
 * 1. 非递减：并不代表严格递增： (2, 2, 2, 2, 2, 2, 1, 2)无法通过测试用例
 * 2. 最后两个不知道如何计算
 */
public class Solution {
    public static ArrayList<Integer> results = new ArrayList<>();

    public int minNumberInRotateArray(int [] array) {
        starcMinNumberInRotateArray(array,0,array.length-1);
        int min = Integer.MAX_VALUE;
        for (int i:results) {
            if(min>i){
                min=i;
            }
        }
        return min;
    }

    public static void starcMinNumberInRotateArray(int [] array,int start,int end) {
        int themin=Integer.MAX_VALUE;
        if(array.length==0){
            themin=0;
        }
        if(array[0]<array[array.length-1]){
            themin = array[0];
        }else{
            int mid = (start + end)/2;
            while(end-start>1){
                if(array[start]==array[mid]){
                    // 我觉得应该递归
                    starcMinNumberInRotateArray(array,start,mid);
                    starcMinNumberInRotateArray(array,mid,end);
                    break;
                } else if(array[start]>array[mid]){
                    start=start;
                    end = mid;
                    mid = (start+end)/2;
                } else {
                    start=mid;
                    end = end;
                    mid = (start+end)/2;
                }
            }
            themin = array[end];
        }
        results.add(themin);
    }



}

//    public static void main(String[] args) {
//        int[] ints = {3,4,5,1,2};
//        Solution solution = new Solution();
//        System.out.println(solution.minNumberInRotateArray(ints));
//    }