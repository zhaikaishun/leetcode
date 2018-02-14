package 剑指offer.跳台阶;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.JumpFloor(4));
    }

    public int JumpFloor(int target) {
        if(target==1){
            return 1;
        } else if(target==2){
            return 2;
        }else{
            return JumpFloor(target-2)+JumpFloor(target-1);
        }
    }
}
