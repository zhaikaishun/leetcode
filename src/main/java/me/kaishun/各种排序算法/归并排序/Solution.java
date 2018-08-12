package me.kaishun.各种排序算法.归并排序;

/**
 *
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {5,2,8,1,4,3,9};
        mergeSort(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    /**
     *
     * @param a
     * @param left
     * @param right
     */
    public static  void mergeSort(int[] a, int left, int right){
        int mid = left+(right-left)/2;
        if(left<right){
            // 左边
            mergeSort(a,left,mid);
            //右边
            mergeSort(a,mid+1,right);
            //左右合并
            merge(a,left,mid,right);
        }

    }

    private static void merge(int[] array, int left, int mid, int right) {
        int[] tmp = new int[right-left+1]; //创建一个临时数组
        int i = left; //左指针
        int j=mid+1;
        int k =0;
        while (i<=mid && j<=right){
            if(array[i]<array[j]){
                tmp[k++]=array[i++];
            }else {
                tmp[k++]=array[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            tmp[k++] = array[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= right) {
            tmp[k++] = array[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < tmp.length; k2++) {
            array[k2 + left] = tmp[k2];
        }

    }

}
