package hard;

import java.util.*;

/**
 * @author siianchan
 * @since 2023/12/12 14:06
 */
public class SecondGreaterElement {
    /**
     * 给你一个下标从 0 开始的非负整数数组 nums 。对于 nums 中每一个整数，你必须找到对应元素的 第二大 整数。
     * 如果 nums[j] 满足以下条件，那么我们称它为 nums[i] 的 第二大 整数：
     * j > i
     * nums[j] > nums[i]
     * 恰好存在 一个 k 满足 i < k < j 且 nums[k] > nums[i] 。
     * 如果不存在 nums[j] ，那么第二大整数为 -1 。
     * 比方说，数组 [1, 2, 4, 3] 中，1 的第二大整数是 4 ，2 的第二大整数是 3 ，3 和 4 的第二大整数是 -1 。
     * 请你返回一个整数数组 answer ，其中 answer[i]是 nums[i] 的第二大整数。
     */
    public static void main(String[] args) {
        int[] test = new int[]{2, 4, 0, 9, 6};
        int[] ret = new SecondGreaterElement().nextGreaterElements(test);
        Arrays.stream(ret).forEach(System.out::println);
    }

    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        List<Integer> stack1 = new ArrayList<>();
        List<Integer> stack2 = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            int v = nums[i];
            while (!stack2.isEmpty() && nums[stack2.get(stack2.size() - 1)] < v) {
                res[stack2.get(stack2.size() - 1)] = v;
                stack2.remove(stack2.size() - 1);
            }
            int pos = stack1.size() - 1;
            while (pos >= 0 && nums[stack1.get(pos)] < v) {
                --pos;
            }
            for (int j = pos + 1; j < stack1.size(); j++) {
                stack2.add(stack1.get(j));
            }
            for (int j = stack1.size() - 1; j >= pos + 1; j--) {
                stack1.remove(j);
            }
            stack1.add(i);
        }
        return res;
    }

    public int[] nextGreaterElements(int[] nums) {
        //查找数组中下一个大于他的数
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            //单调栈
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return result;
    }

}
