package easy;

import java.util.List;

/**
 * @author siianchan
 * @since 2024/1/25 15:24
 */
public class SumIndicesWithKSetBits {
    /**
     * 2859. 计算 K 置位下标对应元素的和
     * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
     * 请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。
     * 整数的二进制表示中的 1 就是这个整数的 置位 。
     * 例如，21 的二进制表示为 10101 ，其中有 3 个置位。
     */
    public static void main(String[] args) {

    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ret = 0;
        for (int x = 0; x < nums.size(); x++) {
            if (Integer.bitCount(x) == k) {
                ret += nums.get(x);
            }
        }
        return ret;
    }
}
