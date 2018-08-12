package me.kaishun.剑指offer.数值的整数次方;

/**
 * Created by Administrator on 2018/2/15.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().Power(2,3));
        System.out.println(new Solution().Power1(2,3));
        System.out.println(new Solution().myPower(2,3));
    }
    // 这道题应该用递归算法，这样的话，时间复杂度是o(logN)
    public double Power(double base, int exponent) {
        int n=0;
        double result=0;
        if(exponent<0){
            n=-exponent;
        }else{
            n=exponent;
        }
        if(n==0){
            return 1;
        }else if(n==1){
            return base;
        }else{
            result = Power(base,n>>1);
            result*=result;
            if((n&1)==1){
                //奇数还需要乘一次本身
                result*=base;
            }
            if(exponent<0){
                result = 1/result;
            }
            return result;
        }

    }

    //肯定不能让我们使用函数
    public double myPower(double base, int exponent) {
        return Math.pow(base,exponent);
    }
    // 使用累乘，时间复杂度为o(n)
    public double Power1(double base, int exponent) {
        int result=0;
        for (int i = 0; i <exponent ; i++) {
            result*=base;
        }
        if(exponent==0){
            return 1;
        }else if(exponent>0){
            return result;
        }else {
            return 1/result;
        }
    }
}
