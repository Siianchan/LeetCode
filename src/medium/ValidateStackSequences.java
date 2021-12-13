package medium;

import java.util.Stack;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/13 19:33
 * @Description:
 */


/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5}
 * 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * 示例 1：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 */

public class ValidateStackSequences {
    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 1, 2}));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> test = new Stack();
        Stack<Integer> push = new Stack();
        Stack<Integer> pop = new Stack();
        for (int x = pushed.length - 1; x >= 0; x--) {
            push.push(pushed[x]);
            pop.push(popped[x]);
        }
        while (!pop.isEmpty()) {
            int a = pop.peek();
            if (!push.isEmpty() && push.peek() == a) {
                push.pop();
                pop.pop();
                continue;
            }
            if (!test.isEmpty() && test.peek() == a) {
                test.pop();
                pop.pop();
                continue;
            }
            if (!push.isEmpty()) {
                test.push(push.pop());
            } else {
                return false;
            }
        }
        return true;
    }
}
