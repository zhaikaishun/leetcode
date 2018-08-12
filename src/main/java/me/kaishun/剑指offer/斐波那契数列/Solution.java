package me.kaishun.剑指offer.斐波那契数列;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项。
 * n<=39
 * 1,1,2,3,5,8,13
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.Fibonacci1(20));
        System.out.println(solution.Fibonacci(20));
    }

    /**
     * 递推方法，只能用这种
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        int last_2=1;
        int last_1=1;
        int thisFib=0;
        if(n<=0){
            return 0;
        }
        if(n==1 || n==2){
            thisFib = 1;
        }else {
            for (int i = 3; i <=n ; i++) {
                thisFib = last_1+last_2;
                last_2=last_1;
                last_1=thisFib;
            }
        }

        return thisFib;
    }
    //递归方法
    public int Fibonacci1(int n){
        if(n<=0){
            return 0;
        }
        else if(n==1 || n==2){
            return 1;
        }else{
            return Fibonacci1(n-1)+Fibonacci1(n-2);
        }

    }
}

