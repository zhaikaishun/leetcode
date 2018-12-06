package me.kaishun.最基础的算法.朋友圈个数;

public class Solution {
    public static void main(String[] args) {
        int[][] arr = {{ 1, 2 } ,{ 2, 3 },{3,4},{ 4, 8 },{9,10}};
        System.out.println(new Solution().friends(7, 5, arr));
    }
    private int[] set = new int[1000];
    int friends(int n, int m, int[][] r) {
        int i, count;
        for (int j = 0; j <r.length ; j++) {
            // 对每个数字，都赋值为相同的数,
            // 即arr[1]=1, set[2]=2, set[3]=3, set[4]=4, set[8]=8,set[9]=9,set[10]=10
            for (int k = 0; k <r[j].length ; k++) {
                set[r[j][k]]=r[j][k];
            }
        }
        for (i = 0; i < m; i++){
            //合并操作
            join(r[i][0], r[i][1]);
        }
        //有多少个不相等的，就有多少个朋友圈
        count = 0;
        for (i = 1; i < set.length; ++i) {
            if (set[i] == i){
                count++;
            }
        }
        return count;
    }
    // 并查集union操作
    public void join(int x, int y) {
        //找到x属于哪个
        int t = find(x);
        //找到y属于哪个
        int h = find(y);
        // x和y本来就要在一起，然后找到他们属于的最小的那个，将这两个都归属于最小的那个
        if (t < h){
            set[h] = t;
        } else{
            set[t] = h;
        }
    }

    //并查集find操作
    public int find(int x) {
        int i, j, r;
        r = x;
        if (set[r] == r){
           return r;
        }else {
            set[r]=find(set[r]);
            return set[r];
        }
    }

}
