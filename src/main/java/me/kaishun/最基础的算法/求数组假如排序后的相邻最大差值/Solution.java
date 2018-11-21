package me.kaishun.最基础的算法.求数组假如排序后的相邻最大差值;

/**
 * Created by Administrator on 2018\11\21 0021.
 * 求数组可能排序后的相邻最大差值，例如3,1,6,2,7。 假如排序后是1,2,3,6,7. 所以最大差值是6-3=3
 * 要求时间复杂度为o(n),不能进行排序（非比较的排序）
 */
public class Solution {
    public static void main(String[] args) {
        int[] arrs = {9,3,1,10};
        System.out.println(new Solution().maxGap(arrs));
    }
    public int maxGap(int[] nums){
        if(nums==null||nums.length<2){
            return 0;
        }
        int[] maxArr = new int[nums.length+1];
        int[] minArr = new int[nums.length+1];
        boolean[] haveNumArr = new boolean[nums.length+1];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        if(max==min){
            return 0;
        }
        for (int num : nums) {
            int index = bucket(num,nums.length,min,max);
            maxArr[index] = haveNumArr[index]?Math.max(maxArr[index],num):num;
            minArr[index] = haveNumArr[index]?Math.min(minArr[index],num):num;
            haveNumArr[index]=true;
        }
        //开始遍历了
        int lastMax = Integer.MIN_VALUE;
        int maxGap=Integer.MIN_VALUE;
        boolean firstNotNull = false;
        for (int i = 0;i<haveNumArr.length;i++) {
            if(haveNumArr[i]){
                if(firstNotNull==false){
                    //第一次找到不为空的
                    lastMax = maxArr[i];
                    firstNotNull=true;
                }else {
                   maxGap = Math.max(maxGap,minArr[i]-lastMax);
                   lastMax = maxArr[i];
                }
            }
        }
        return maxGap;
    }

    private int bucket(int num, int length, int min, int max) {
        return (num-min) * length/(max-min);
    }
}
