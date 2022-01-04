package medium;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/1/4 13:59
 * @Description:
 */
public class MaxQueue {

    ArrayDeque<Integer> queue = new ArrayDeque();
    ArrayDeque<Integer> maxQueue = new ArrayDeque();

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);

        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.pop_front());
    }

    public MaxQueue() {

    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.pollLast();
        }
        maxQueue.addLast(value);
        queue.addLast(value);
    }

    public int pop_front() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        int ret = queue.pop();
        if (ret == maxQueue.peek()) {
            maxQueue.pop();
        }
        return ret;
    }
}
