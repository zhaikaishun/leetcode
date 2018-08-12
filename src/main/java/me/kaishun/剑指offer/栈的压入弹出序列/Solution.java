package me.kaishun.剑指offer.栈的压入弹出序列;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,2,1};
//        int[] pushA = {1};
//        int[] popA = {2};
        System.out.println(solution.IsPopOrder(pushA,popA));
    }

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean flag = true;
        if(pushA.length!=popA.length){
            return false;
        }
        // 用一个临时的辅助栈来实现
        Stack<Integer> tmpStack = new Stack<>();
        int i =0;
        int j =0;
        while (i<pushA.length&&j<popA.length){
            tmpStack.push(pushA[i]);
            i++;
            // 找到一个相同的值,找不到的话，就再进行push，i++
            if(tmpStack.peek()!=popA[j]){
                continue;
            }else{
                // 如果找到了一个相同的值，那么就进行
                while(!tmpStack.empty()){
                    tmpStack.pop();
                    j++;
                    if(tmpStack.empty() || tmpStack.peek()!=popA[j]){
                        break;
                    }else{
                        // tmpStack等于popA里面的值的话，继续将tmpStack进行pop
                        continue;
                    }
                }
            }
        }
        while (!tmpStack.empty()){
            if(j<popA.length){
                if(tmpStack.pop()!=popA[j]){
                    flag = false;
                    break;
                }
                j++;
            }else{
                break;
            }

        }
        return flag;
    }

    public boolean myPopOrder(int [] pushA,int [] popA) {




        return true;
    }
}
