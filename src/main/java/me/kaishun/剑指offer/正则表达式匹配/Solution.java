package me.kaishun.剑指offer.正则表达式匹配;

/**
 * 太恶心，不做了
 */
public class Solution {
    public static void main(String[] args) {

        char[] str = {'a','a','a'};
        char[] str1 = {};
        // "a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
        char[] pattern0 = {'a','.','a'};
        char[] pattern1 = {'a','b','*','a','*','c','*','a'};
        char[] pattern2 = {'a','a','.','a'};
        char[] pattern3 = {'a','b','*','a'};
        char[] pattern4 = {'c','*'};
        char[] pattern5 = {'a','*'};
        boolean match = new Solution().match(str, pattern1);
        System.out.println(match);

    }

    public boolean match(char[] str, char[] pattern) {
        if(pattern==null || str==null || (str.length==0 && pattern.length==0)){
            return true;
        }
        if(str.length>0 && pattern.length==0){
            return false;
        }

        if(pattern[0]=='*'){
            return false;
        }

        if(pattern.length>1 && pattern[0]== '.' && pattern[1]=='*'){
            return true;
        }


        int i = 0;
        int j = 0;
        boolean flag = true;
        while (i<str.length&&j<pattern.length){
            if(pattern[j]!='*' && pattern[j]!='.'){
                if (str[i] == pattern[j]) {
                    i++;
                    j++;
                }else {
                    j++;
                    if(j<pattern.length){
                      if(pattern[j]=='*'){
                          j++;
                          continue;
                      }else{
                          flag = false;
                          break;
                      }
                    }
                    flag = false;
                    break;
                }
            }else if(pattern[j]=='.'){
                pattern[j] = str[i];
                i++;
                j++;
            }else if(pattern[j]=='*'){
                // 得到j的前一位
                //从i开始，如果等于j的前一位，i一直完后
                if(str[i]!=pattern[j-1]){
                    flag = false;
                    break;
                }
                while (i<str.length){
                    if(str[i]==pattern[j-1]){
                        i++;
                    }else {
                        break;
                    }
                }
                // 看看j的后一位是不是等于前几位，如果是的话，就一直移动
                char tmp = pattern[j-1];
                while (j<pattern.length){
                    j++;
                    if(j==pattern.length){
                        break;
                    }
                    if(pattern[j]=='.'||pattern[j]=='*'){
                        pattern[j] = tmp;
                    }
                    if(tmp!=pattern[j]){
                        break;
                    }
                }
            }
        }



        if(j<pattern.length){
            int k = pattern.length-j;
            // 看看后面多的是否可以自己消去
            int theTmp =0;
            int f = 0;
            if(pattern[j]=='*'){
                f = 1;
            }
            while (f<k){
                if(pattern[(f+j)]=='*'){
                    theTmp++;
                }else {
                    theTmp--;
                }
                if(theTmp<-1){
                    return false;
                }
                f++;
            }
            if(theTmp!=0){
                return false;
            }else {
                return true;
            }
        }

        if(i<str.length){
            if(pattern[j-1]!='*'){
                return false;
            }else {
                while (i<str.length){
                    if(str[i]!=pattern[j-1]){
                        flag = false;
                        break;
                    }
                }
            }

        }
        return flag;

    }
}
