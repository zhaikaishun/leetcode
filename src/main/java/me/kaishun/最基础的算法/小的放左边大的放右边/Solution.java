package me.kaishun.最基础的算法.小的放左边大的放右边;

/**
 * Created by Administrator on 2018\11\19 0019.
 */
//小的放左边，小的放右边
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,4,6,5,3,2,4,1,1};
        new Solution().partition(arr,3);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    public void partition(int[] arr,int p){
        int left = 0;
        int right = arr.length-1;
        doPartition(arr,left,right,p);
    }
    public void doPartition(int[] arr,int left,int right,int p){
        while (left<=right){
            if(arr[left]>p){
                swap(arr,left,right);
                right--;
            }else {
                left++;
            }
        }
    }
    public void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
