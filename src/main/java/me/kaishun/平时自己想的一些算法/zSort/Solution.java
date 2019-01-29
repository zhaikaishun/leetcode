package me.kaishun.平时自己想的一些算法.zSort;

public class Solution {
    public static void main(String[] args) {

        int[][] ints = new int[1024][1024];
        int index = 1;
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                ints[j][i] = index;
                index++;
            }
        }
        zSort(ints,1,1,ints.length,ints.length);
    }


    public static void zSort(int[][] arr,int x1,int y1,int x2, int y2){
        if(y2==y1&&x2==x1){
            System.out.println(arr[x1-1][y1-1]);
            return;
        }
        zSort(arr, x1,y1,x1+(x2-x1)/2,y1+(y2-y1)/2);
        zSort(arr, 1+x1+(x2-x1)/2,y1,x2,y1+(y2-y1)/2);
        zSort(arr, x1,1+y1+(y2-y1)/2,x1+(y2-y1)/2,y2);
        zSort(arr, 1+x1+(x2-x1)/2,1+y1+(y2-y1)/2,x2,y2);
    }
}
