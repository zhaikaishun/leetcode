package 剑指offer.调整数组顺序使奇数位于偶数前面;

/**
 * Created by Administrator on 2018/2/15.
 */
public class Solution {
    public void reOrderArray(int [] array) {

    }

    // 这肯定不是一个好的选择
    public void myReOrderArray(int [] array) {
        int[] results = new int[array.length];
        int index1 =0;
        for (int i = 0; i <array.length ; i++) {
            if((array[i]&1)==1){
                results[index1]=array[i];
                index1++;
            }
        }
        for (int i = 0; i <array.length ; i++) {
            if((array[i]&1)==0){
                results[index1]=array[i];
                index1++;
            }
        }
        for (int i = 0; i <results.length ; i++) {
            array[i]=results[i];
        }
    }
}
