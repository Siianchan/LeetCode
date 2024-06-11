package easy;

/**
 * @author siianchan
 * @since 2024/6/7 11:44
 */
public class MaxOperations {
    /**
     * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作：
     * 选择 nums 中的前两个元素并将它们删除。
     * 一次操作的 分数 是被删除元素的和。
     * 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
     * 请你返回按照上述要求 最多 可以进行的操作次数。
     */
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("1.11"));
    }
    public int maxOperations2(int[] nums) {
        if (nums.length < 2) return 0;
        int count = nums[0] + nums[1];
        int ret = 1;
        for (int x = 2; x < nums.length - 1; x += 2) {
            int sum = nums[x] + nums[x + 1];
            if (sum == count) {
                ret++;
            } else {
                break;
            }
        }
        return ret;
    }

    public int maxOperations(int[] nums) {
        int count = -1;
        int ret = 0;
        for (int x = 0; x < nums.length - 1; x++) {
            int sum = nums[x] + nums[++x];
            if (count >= 0) {
                if (count == sum) {
                    ret++;
                } else {
                    break;
                }
            } else {
                count = sum;
                ret++;
            }
        }
        return ret;
    }
}
