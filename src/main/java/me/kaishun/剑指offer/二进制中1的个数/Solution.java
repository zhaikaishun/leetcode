package me.kaishun.剑指offer.二进制中1的个数;

/**
 * Created by Administrator on 2018/2/15.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().NumberOf1(5));
        System.out.println(new Solution().NumberOf1(7));
        System.out.println(new Solution().NumberOf1(8));
    }
    public int NumberOf1(int n) {
        int count=0;

        while(n!=0){
            count++;
            n=n&(n-1);
        }

        return count;
    }
}
