package easy;


/**
 * @author siianchan
 * @since 2024/5/9 14:34
 */
public class TripleInOne {

    /**
     * 三合一。描述如何只用一个数组来实现三个栈。
     * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。
     * stackNum表示栈下标，value表示压入的值。
     * 构造函数会传入一个stackSize参数，代表每个栈的大小。
     * 示例1:
     * 输入：
     * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
     * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
     * 输出：
     * [null, null, null, 1, -1, -1, true]
     * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
     */


    int[][] stack;
    int[] stackLocation;

    public TripleInOne(int stackSize) {
        stack = new int[3][stackSize];
        stackLocation = new int[3];
    }

    public void push(int stackNum, int value) {
        if (stackLocation[stackNum] < stack[stackNum].length) {
            stack[stackNum][stackLocation[stackNum]] = value;
            stackLocation[stackNum]++;
        }
    }

    public int pop(int stackNum) {
        int arr = stackLocation[stackNum];
        if (arr == 0) {
            return -1;
        }
        int ret = stack[stackNum][arr - 1];
        stack[stackNum][arr - 1] = 0;
        stackLocation[stackNum]--;
        return ret;
    }

    public int peek(int stackNum) {
        if (stackLocation[stackNum] == 0) {
            return -1;
        }
        return stack[stackNum][stackLocation[stackNum] - 1];
    }

    public boolean isEmpty(int stackNum) {
        return stackLocation[stackNum] == 0;
    }
}
