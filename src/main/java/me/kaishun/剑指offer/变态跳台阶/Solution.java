package me.kaishun.剑指offer.变态跳台阶;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 这种题目就是找规律
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.JumpFloorII(4));
    }

    public int JumpFloorII(int target) {
        return 1<<(target-1);
    }
}
