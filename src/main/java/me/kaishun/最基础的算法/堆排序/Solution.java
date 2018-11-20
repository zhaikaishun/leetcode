package me.kaishun.最基础的算法.堆排序;

/**
 * Created by Administrator on 2018\11\20 0020.
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {1,4,6,5,3,2,3,2,11,3,7,4};
        heapSort(array);
        for (int i : array) {
            System.out.print(i+",");
        }
    }
    public static void heapSort(int[] arr){
        if (arr == null || arr.length < 2) {
            return;
        }
        //建立一个大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        for (int j = arr.length-1; j >0 ; j--) {
            swap(arr, 0, j);
            heapify(arr, 0, j);
        }

    }

    private static void heapify(int[] arr, int i, int size) {
        int left = i*2+1;
        while (left<size){
            //比较做子节点和右子节点
            int largest = left+1<size&&arr[left]<arr[left+1]?left+1:left;
            if(arr[i]>=arr[largest]){
                break;
            }else {
                swap(arr,i,largest);
                i=largest;
                left=i*2+1;
            }
        }
    }

    private static void heapInsert(int[] arr, int i) {
        while (i>0){
            if (arr[(i-1)/2]<arr[i]) {
                swap(arr,(i-1)/2,i);
            }
            i=(i-1)/2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
