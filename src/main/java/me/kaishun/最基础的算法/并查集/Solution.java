package me.kaishun.最基础的算法.并查集;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().friends(8, 5, new int[][] { { 1, 2 }, { 4, 5 } , { 2, 3 },{8,2},{9,10}}));
    }


    private int[] set = new int[1000];
    public int find(int x) { // 带路径优化的并查集查找算法
        int i, j, r;
        r = x;
        while (set[r] != r){
            r = set[r];
        }
        i = x;
        while (i != r) {
            j = set[i];
            set[i] = r;
            i = j;
        }
        return r;
    }

    public void join(int x, int y) { // 优化的并查集归并算法
        int t = find(x);
        int h = find(y);
        if (t < h){
            set[h] = t;
        } else{
            set[t] = h;
        }
    }

    int friends(int n, int m, int[][] r) {
        int i, count;
        for (i = 1; i <= n; ++i){
            set[i] = i;// 初始化并查集，各点为孤立点，分支数为n
        }
        for (i = 0; i < m; ++i){
            join(r[i][0], r[i][1]);
        }
        count = 0;
        for (i = 1; i <= n; ++i) {
            if (set[i] == i){
                count++;
            }
        }
        System.out.println(set[8]);
        return count;
    }
}
