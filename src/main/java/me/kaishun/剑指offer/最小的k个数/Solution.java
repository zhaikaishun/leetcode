package me.kaishun.剑指offer.最小的k个数;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */


/*
  思路： 1. 从小到大排序，取前k个。 排序的方式有很多种，比如快排，归并排序，堆排序等，大数据的话，就需要使用分区的思想
  普通排序NlogN, 堆排序取前K个， NlogK， 还有一种BFPRT算法，以后有时间再说了

 */
public class Solution {

    public static void main(String[] args) {
        int[] arr = {5,2,8,1,4,3,9};

        System.out.println(new Solution().GetLeastNumbers_Solution(arr,4));
    }

    public  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if(k>input.length){
            return new ArrayList<>();
        }

        heapSort(input,k);
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = input.length-1; i >= input.length-k; i--) {
            integers.add(input[i]);
        }
        return integers;
    }


    private  void heapSort(int[] input, int k) {
        // 1. 构建小顶堆
        //从第一个非叶子结点从下至上，从右至左调整结构
        for (int i = input.length/2-1; i >=0 ; i--) {
            adjustHeap(input,i,input.length);
        }

        // 2. 交换元素,调整小顶堆，只需要调整k次即可
        for (int i = input.length-1; i >=input.length-k ; i--) {
            swap(input,0,i);
            adjustHeap(input,0,i);
        }


    }

    private  void adjustHeap(int[] input, int i, int length) {
        //从下到上的时候，上面的修改会影响到下面, 所以是个for循环
        int k =0;
        while ((k=i*2+1)<length){
            //如果左子结点大于右子结点，k指向右子结点
            if(k+1<length && input[k]>input[k+1]){
                k++;
            }
            //如果父节点大于子节点，则交换元素，否则跳出循环
            if(input[i]>input[k]){
                swap(input,i,k);
            }else{
                break;
            }
            i = k;
        }
    }

    private  void swap(int[] input, int i, int k) {
        int temp = input[i];
        input[i] = input[k];
        input[k] = temp;
    }

}
