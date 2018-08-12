package me.kaishun.剑指offer.二维数组中的查找;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {
    public static void main(String[] args) {
        int target = 1;
        int[][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(Find(target,array));
    }
    public static boolean Find(int target, int[][] array){
        int indexI = array.length-1;
        int indexJ = 0;
        while(indexI>=0 && indexJ<=array[0].length-1)
        {
            if( target > array[indexI][indexJ]){
                indexJ++;
            }
            else if(target<array[indexI][indexJ]){
                indexI--;
            }
            else{
                return true;
            }
        }
        return false;
    }
}
