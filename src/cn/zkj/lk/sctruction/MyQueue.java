package cn.zkj.lk.sctruction;

import java.util.Stack;

/**
 * @Author: zhaoKaiJie
 * @Description: 232. 用栈实现队列
 * @Date: 2021/3/5
 * @version: 01
 */
public class MyQueue {

    private Stack<Integer> input ;
    private Stack<Integer> outPut;

    /** Initialize your data structure here. */
    public MyQueue() {
        input = new Stack<>();
        outPut = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outPut.empty()){
            if (input.isEmpty()){
                return 0;
            }
            while (!input.isEmpty()){
                outPut.push(input.pop());
            }
        }
        return outPut.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outPut.empty()){
            if (input.isEmpty()){
                return 0;
            }
            while (!input.isEmpty()){
                outPut.push(input.pop());
            }
        }
        return outPut.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty()&&outPut.empty();
    }
}
