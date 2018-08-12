package me.kaishun.剑指offer.数组中重复的数组;

public class Solution {
    /*
    题目如下:
    在一个长度为n的数组里的所有数字都在0到n-1的范围内。
     数组中某些数字是重复的，但不知道有几个数字是重复的。
     也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
     例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     */

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    //方式一，hashMap的方法
    //方式二，建立长度为length的boolean数组，便利numbers，如果是false就赋值true，否则就赋值为false

    //最终方式，不用额外的空间，而且时间复杂度是o(n)
    /*
此大法利用了哈希的特性，但不需要额外的存储空间。因此时间复杂度为O(n)，不需要额外空间！
把当前序列当成是一个下标和下标对应值是相同的数组；
遍历数组，判断当前位的值和下标是否相等：
2.1. 若相等，则遍历下一位；
2.2. 若不等，则将当前位置i上的元素和a[i]位置上的元素比较：若它们相等，则成功！
若不等，则将它们两交换。换完之后a[i]位置上的值和它的下标是对应的，
但i位置上的元素和下标并不一定对应；重复2.2的操作，直到当前位置i的值也为i，将i向后移一位，再重复2.
     */

    public static void main(String[] args) {
        int[] ints = {4, 5, 7, 3, 2, 1, 0, 6};
        int length = 8;
        int[] results = new int[1];
        boolean duplicate = new Solution().duplicate(ints, length, results);
        System.out.println(duplicate);
        System.out.println("results: "+results[0]);

        int[] ints1 = {4, 5, 7, 6, 2, 1, 0, 6};
        int[] results1 = new int[1];
        boolean duplicate1 = new Solution().duplicate(ints1, length, results1);
        System.out.println(duplicate1);
        System.out.println("results1: "+results1[0]);

    }

    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for (int i = 0; i <length ; i++) {
            while (i!=numbers[i]){
                if(numbers[i]==numbers[numbers[i]]){
                    duplication[0]=numbers[i];
                    return true;
                }else{
                    //将numbers[numbers[i]]变成与下表对应的
                    //替换
                    int temp = numbers[i];
                    numbers[i]=numbers[numbers[i]];
                    numbers[temp]=temp;
                }
            }
        }
        return false;
    }
}