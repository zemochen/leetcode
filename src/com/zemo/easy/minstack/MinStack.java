package com.zemo.easy.minstack;

import com.zemo.util.Timer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: MinStack
 * @author: SuperZemo
 * @email: zemochen@gmail.com
 * @Date 11/17/14 21:23
 * @Description Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *              push(x) -- Push element x onto stack.
 *              pop() -- Removes the element on top of the stack.
 *              top() -- Get the top element.
 *              getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {
    public List<Integer> stack = new ArrayList();
    public List<Integer> minStack = new ArrayList();
    public void push(int x) {
        stack.add(x);
        if (minStack.isEmpty() || minStack.get(minStack.size() - 1) >= x)
            minStack.add(x);
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        int elm = stack.remove(stack.size() - 1);
        if (!minStack.isEmpty() && elm == minStack.get(minStack.size() - 1))
            minStack.remove(minStack.size() - 1);
    }

    public int top() {
        return minStack.get(minStack.size() - 1);
    }

    public int getMin() {
        if (minStack.isEmpty())
            return 0;
        else
            return minStack.get(minStack.size() - 1);
    }

    public static void main(String[] args) {
        MinStack min = new MinStack();
        Timer timer = new Timer();
        for (int i = -10000; i < 10000; i++) {
            min.push(i);
        }

        System.out.println(min.getMin());
        System.out.println(min.top());
        min.pop();

        System.out.println(min.top());

        timer.useTime(new Date());
    }
}
