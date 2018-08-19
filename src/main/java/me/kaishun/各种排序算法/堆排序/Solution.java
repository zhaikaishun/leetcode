package me.kaishun.各种排序算法.堆排序;

/**
 * Created by Administrator on 2018\8\19 0019.
 * 参考: https://www.cnblogs.com/chengxiao/p/6129630.html
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {5,2,8,1,4,3,9};
//        int []arr = {9,8,7,6,5,4,3,2,1};
        heapSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void heapSort(int[] arr) {
        // 1. 构建大顶堆
        //从第一个非叶子结点从下至上，从右至左调整结构
        for (int i = arr.length/2-1; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
        // 2. 交换元素,调整大顶堆
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            //再次调整堆结构
            adjustHeap(arr,0,j);
        }
    }


    private static void adjustHeap(int[] arr, int i, int length) {
        int k = 0;
        while ((k=i*2+1)<length){ //从下到上的时候，上面的修改会影响到下面，所以我这里是个for循环
            //如果左子结点小于右子结点，k指向右子结点
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            //如果子节点大于父节点，父节点和子节点进行交换
            if(arr[k]>arr[i]){
                swap(arr,i,k);
            }else{ // 否则下面是排好的，就不用去管了
                break;
            }
            i=k;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
