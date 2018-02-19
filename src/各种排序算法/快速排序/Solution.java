package 各种排序算法.快速排序;

/**
 * Created by Administrator on 2018/2/19.
 */
public class Solution {
    public static void main(String[] args) {
        int[] array = {5,2,8,1,4,3,9};

        quickSort(array,0,array.length-1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }

    /**
     * 原理不难，就是一边都小于某个数，一边都大于某个数，问题是如何分出这两边来
     * @param array
     * @return
     */
    private static void quickSort(int[] array,int start,int end) {
        if(start>=end){
            return ;
        }
        if(start<end){
            //进行一次划分
            int index = oneSort(array, start, end);
            //递归左边
            quickSort(array,start,index);
            //递归右边
            quickSort(array,index+1,end);
        }
    }

    /**
     *
     * @param array 数组
     * @param start 开始的index
     * @param end 结束的index
     * @return 第几个开始划分,返回的是从0开始计数的值
     */
    private static int oneSort(int[] array, int start, int end) {
        int data = array[start];
        while (start<end){
            while (array[end]>=data && start<end){ // 从后半部向前进行扫描
                end--;
            }
            //注意，因为我们每次都把第一个进行比较,这里不能使用等于
            while (array[start]<data && start<end){
                start++;
            }
            // 否则, 如不满足上面的while条件，则两个数进行交换
            if(start<end){
                int tmp = array[start];
                array[start]=array[end];
                array[end]=tmp;
                start++;
                end--;
            }
        }
        return end;
    }
}
