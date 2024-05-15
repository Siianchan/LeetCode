package easy;

import java.util.LinkedList;

/**
 * @author siianchan
 * @since 2024/5/15 17:00
 */
public class MyQueue {

    //实现一个MyQueue类，该类用两个栈来实现一个队列。

    LinkedList<Integer> l1 = new LinkedList<>();
    LinkedList<Integer> l2 = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        //新的值直接push到栈1
        l1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        //当提取的时候，如果栈2为空，将栈1的数倒出来放到栈2就是正的了
        if (l2.isEmpty()) {
            while (!l1.isEmpty()) {
                l2.push(l1.pop());
            }
        }
        return l2.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (l2.isEmpty()) {
            while (!l1.isEmpty()) {
                l2.push(l1.pop());
            }
        }
        return l2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return l1.isEmpty() && l2.isEmpty();
    }
}
