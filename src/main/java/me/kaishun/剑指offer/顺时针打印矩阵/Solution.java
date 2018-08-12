package me.kaishun.剑指offer.顺时针打印矩阵;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵：
 *  1  2  3  4
 *  5  6  7  8
 *  9 10 11 12
 * 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * 自己写的，以后再看答案
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] ints = {{1,2,3,4}, {5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] ints ={{1,2,3,4,5,6,7},{7,8,10,11,12,13,14},{15,16,17,18,19,20,21}} ;
        ArrayList<Integer> integers = solution.printMatrix(ints);
        for (Integer i1:integers) {
            System.out.print(i1+" ");
        }
    }

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> results = new ArrayList<>();
        //规定，下是x，上是y
        int lengthX = matrix.length;
        int lengthY = matrix[0].length;
        //先计算出要打印几圈
        int n = (Math.min(lengthX, lengthY) + 1) / 2;
        for (int k = 0; k <n; k++) {
            //左到右
            for (int i = k; i <lengthY-k ; i++) {
                results.add(matrix[k][i]);
            }
            //上到下
            boolean flag = false; // 用来判断是否执行过上到下
            for (int i = k+1; i <lengthX-k ; i++) {
                flag= true;
                results.add(matrix[i][lengthY-k-1]);
            }
            //右到左, 注意，只有执行过上到下才有右到左
            boolean flag1=false; //用来判断是否执行过右到左
            if(flag){
                for (int i = lengthY-k-2; i >=k ; i--) {
                    flag1=true;
                    results.add(matrix[lengthX-k-1][i]);
                }
            }
            //下到上,注意，只有执行过右到左，才能有上到下
            if(flag1){
                for (int i = lengthX-k-2; i >=k+1 ; i--) {
                    results.add(matrix[i][k]);
                }
            }
        }
        return results;
    }
}
