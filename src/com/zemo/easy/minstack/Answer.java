package com.zemo.easy.minstack;

import java.util.Stack;

/**
 * @ClassName: Answer
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 11/17/14 23:18
 * @Description bcz I don't know java has Stack.class ╮(╯▽╰)╭
 */
public class Answer {
    class MinStack {
        private Stack<Integer> stack = new Stack<Integer>();
        private Stack<Integer> minStack = new Stack<Integer>();

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (stack.pop().equals(minStack.peek())) minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
