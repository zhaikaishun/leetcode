package me.kaishun.剑指offer.字符串的排列;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 输入描述:
 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
/*
   最开始想： 就是一个递归。 先考虑简单的递归，不用动态规划，缓存什么的，因为毕竟只有9个，多的话，就要使用缓存了

   递归的做法就是 参考图片地址
   https://uploadfiles.nowcoder.net/images/20170705/7578108_1499250116235_8F032F665EBB2978C26C4051D5B89E90

 */
public class Solution {

    public static void main(String[] args) {
        String str = "abc";
        ArrayList<String> permutation = new Solution().Permutation(str);
        System.out.println(permutation.toString());
    }

    public ArrayList<String> Permutation(String str) {

        ArrayList<String> strings = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        recursion(str.toCharArray(),0,set);
        for (String o : set) {
            strings.add(o);
        }
        Collections.sort(strings);
        return strings;
    }

    // 递归，这个方法先不考虑效率问题（因为明显重算了太多）
    public static void recursion(char[] cr, int index,HashSet<String> set){

        //如果是最后一个，那么判断这个有没有加入，没有加入的话，就加进来
        if(index==cr.length-1){
            String value = String.valueOf(cr);
            set.add(value);
        }

        for (int j = index; j <cr.length ; j++) {
            //交换第一个（递归后子串的第一个）和其他的
            swap(cr,index,j);
            //将每个子串的首字母拿出后，进行递归
            recursion(cr,index+1,set);
            //算完后，再交换回来，继续循环另外一个字母
            swap(cr,index,j);
        }

    }

    // 交换两个
    private static void swap(char[] cr, int index, int j) {
        char tmp = cr[j];
        cr[j] = cr[index];
        cr[index] = tmp;
    }


    //更好的办法： 暂时先不思考了, 有空再回来，估计就是加一些缓存，使用动态规划之类的



}
