package me.kaishun.剑指offer.包含min函数的栈;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
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
