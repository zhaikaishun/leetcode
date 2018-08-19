package me.kaishun.剑指offer.丑数;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */

/*
 思路： 最简单的，也就是一眼就能想到的，就是从1开始不断的遍历
 如果判断是丑数，那么就+1， 知道加到N就停止

 判断是否为丑数的方法如下：
首先除2，直到不能整除为止，然后除5到不能整除为止，然后除3直到不能整除为止。最终判断剩余的数字是否为1，如果是1则为丑数，否则不是丑数。

 肯定有更好的方法，先不说了

 最终发现这种结果会导致算法复杂度太高无法通过编译，那可能就是要找规律之类的了.
 后来发现动态规划类似：  转移方程式： 丑数可以通过前面的丑数*2,3,5来得到。
 那么是不是可以用递推或者动态规划的方式来做

 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().GetUglyNumber_Solution(4));
    }


    // 动态规划的方式(不应该叫做动态规划，应该叫做递推的方式)
    ////要注意，后面的丑数是有前一个丑数乘以2，3，5中的一个得来。因此可以用动态规划去解
    public int GetUglyNumber_Solution(int index){
        if (index<=0) {
            return 0;
        }
        if (index==1){
            return 1;
        }
        int[] uglyArr = new int[index];
        uglyArr[0] = 1;
        int t2=0,t3=0,t5=0;
        for (int i = 1; i < uglyArr.length; i++) {
            uglyArr[i] = Math.min(uglyArr[t2]*2,Math.min(uglyArr[t3]*3,uglyArr[t5]*5));
            if(uglyArr[i]==uglyArr[t2]*2){
                t2++;
            }
            if(uglyArr[i]==uglyArr[t3]*3){
                t3++;
            }
            if(uglyArr[i]==uglyArr[t5]*5){
                t5++;
            }

        }
        return uglyArr[index-1];
    }


    //这种方法无法通过编译
    public int GetUglyNumber_Solution1(int index) {
        if(index<=0){
            return 0;
        }
        int curCount=0;
        int num = 0;
        while (curCount<index){
            boolean isUglyNumber = judgeUglyNum(++num);
            if(isUglyNumber){
                curCount++;
            }
        }
        return num;
    }

    private boolean judgeUglyNum(int i) {

        while (i%2==0){
            i = i/2;
        }
        while (i%5==0){
            i = i/5;
        }
        while (i%3==0){
            i=i/3;
        }
        if(i==1){
            return true;
        }
        return false;
    }
}
