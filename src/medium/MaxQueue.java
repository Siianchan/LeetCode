package medium;

import java.util.ArrayDeque;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/1/4 13:59
 * @Description:
 */
public class MaxQueue {

    /**
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，
     * 要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
     * 若队列为空，pop_front 和 max_value 需要返回 -1
     * 示例 1：
     * 输入:
     * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
     * [[],[1],[2],[],[],[]]
     * 输出: [null,null,null,2,1,2]
     */


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
