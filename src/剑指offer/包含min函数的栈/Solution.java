package 剑指offer.包含min函数的栈;

import java.util.Stack;

/**
 * Created by Administrator on 2018/2/17.
 */
public class Solution {

    Stack<Integer> dataStack =  new Stack<Integer>();
    Stack<Integer> minStack =  new Stack<Integer>();
    public void push(int node) {
        if(minStack.empty()){
            minStack.push(node);
        }else{
            if(node<=minStack.peek()){
                minStack.push(node);
            }
        }
        dataStack.push(node);

    }

    public void pop() {
        Integer pop = dataStack.pop();
        if(pop==minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        return dataStack.peek();

    }

    public int min() {
        return minStack.peek();
    }
}
