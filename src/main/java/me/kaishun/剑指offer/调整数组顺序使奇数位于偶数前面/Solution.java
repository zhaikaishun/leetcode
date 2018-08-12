package me.kaishun.剑指offer.调整数组顺序使奇数位于偶数前面;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
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
