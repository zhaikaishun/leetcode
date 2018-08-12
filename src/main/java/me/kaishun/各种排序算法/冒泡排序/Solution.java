package me.kaishun.各种排序算法.冒泡排序;

/**
 * Created by Administrator on 2018/2/19.
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {2,5,8,1,4};
        int[] ints = bubbleSort(array);
        for (int i = 0; i <ints.length ; i++) {
            System.out.print(ints[i]+" ");
        }
    }
    // 冒泡排序
    public static int[] bubbleSort(int [] array) {
        int len = array.length;
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <len-i-1 ; j++) {
                if(array[j]>array[j+1]){
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        return array;
    }
}
