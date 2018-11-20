package me.kaishun.最基础的算法.快排之随机算法;

/**
 * Created by Administrator on 2018\11\20 0020.
 */
public class Solution {
    public static void main(String[] args) {
//        int[] array = {5,2,8,1,4,3,9};  //int[] array = {1,4,6,5,3,2,3}; 这个排序就有问题
        int[] array = {1,4,6,5,3,2,3,2,11,3,7,4};
        new Solution().quickSort(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    /**
     * 原理不难，就是一边都小于某个数，一边都大于某个数，问题是如何分出这两边来
     * @param array
     * @return
     */
    private  void quickSort(int[] array,int start,int end) {
        if(start>=end){
            return ;
        }

        //进行一次划分
        int p[] = partition(array, start, end);
        //递归左边
        quickSort(array,start,p[0]-1);
        //递归右边
        quickSort(array,p[1]+1,end);

    }

    /**
     * 荷兰国旗问题
     * @param array
     * @param start
     * @param end
     * @return
     */
    private  int[] partition(int array[] ,int start, int end) {
        int less = start - 1;
        int more = end+1;
        int randomNum = end-(int) (Math.random() * (end - start + 1));// 随机排序就是随机取一个数而已
        int number = array[randomNum];
        while (start<more){
            if(array[start]<number){
                swap(array,++less,start++);
            }else if(array[start]==number){
                start++;
            }else {
                swap(array,start,--more);
            }
        }
        return new int[]{less+1,more-1};
    }
    private  void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
