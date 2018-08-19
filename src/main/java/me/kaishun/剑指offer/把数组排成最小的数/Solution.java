package me.kaishun.剑指offer.把数组排成最小的数;

import java.util.HashSet;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */

/*
  最开始想到的思路: 排列组合搞起来，然后找出最小的。这个挺好实现的
  排列组合的问题，之前在字符串的排列有类似的

  当然肯定有更好的方法，以后再摸索一下
 */
public class Solution {

    public static void main(String[] args) {
        int[] ints = {3334,3,3333332};
        int[] ints1 = {3,32,321};
        System.out.println(new Solution().PrintMinNumber(ints));
    }

    public String PrintMinNumber(int [] numbers) {

        if(numbers==null||numbers.length==0){
            return "";
        }

        HashSet<String> set = new HashSet<>();
        recursion(numbers,0,set);
        long minNum = Long.MAX_VALUE;
        for (String s : set) {
            minNum = Math.min(minNum,Long.parseLong(s));
        }
        return minNum+"";
    }

    // 递归的方法找出排列组合
    private void recursion(int[] numbers,int index, HashSet<String> set) {

        if(index==numbers.length-1){
            String value = "";
            for (int number : numbers) {
                value+=number;
            }
            set.add(value);
        }

        for (int i = index; i < numbers.length; i++) {
            //交换第一个（递归后子串的第一个）和其他的
            swap(numbers,index,i);
            //将每个子串的首字母拿出后，进行递归
            recursion(numbers,index+1,set);
            //算完后，再交换回来，继续循环另外一个字母
            swap(numbers,index,i);
        }
    }

    private void swap(int[] numbers, int index, int i) {
        int temp = numbers[index];
        numbers[index] = numbers[i];
        numbers[i] = temp;
    }
}
