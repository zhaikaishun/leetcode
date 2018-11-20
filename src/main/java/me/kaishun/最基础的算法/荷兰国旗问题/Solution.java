package me.kaishun.最基础的算法.荷兰国旗问题;

/**
 * Created by Administrator on 2018\11\19 0019.
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,4,6,5,3,2,3};
        int[] res = new Solution().partition(arr, 3);
        System.out.println(res[0]+","+res[1]);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    public int[] partition(int[] arr,int p){
        int left = 0;
        int right = arr.length-1;
        int[] ints = doPartition(arr, left, right, p);
        return ints;
    }
    // 自己画一下图就知道怎么回事了
    public int[] doPartition(int[] arr,int left,int right,int p){
        int less = left-1;
        int more=right+1;
        int cur = left;
        while (cur<more){
            if(arr[cur]<p){
                swap(arr,++less,cur++);
            }else if(arr[cur]==p){
                cur++;
            }else {
                swap(arr,cur,--more);
            }
        }
        int[] ints = {less+1, more-1};
        return ints;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
