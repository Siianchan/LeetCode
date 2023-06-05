package easy;

import java.util.Arrays;

/**
 * @author
 * @since 2023/6/5 09:37
 */
public class ApplyOperations {
    /**
     * 给你一个下标从 0 开始的数组 nums ，数组大小为 n ，且由 非负 整数组成。
     * 你需要对数组执行 n - 1 步操作，其中第 i 步操作（从 0 开始计数）要求对 nums 中第 i 个元素执行下述指令：
     * 如果 nums[i] == nums[i + 1] ，则 nums[i] 的值变成原来的 2 倍，nums[i + 1] 的值变成 0 。否则，跳过这步操作。
     * 在执行完 全部 操作后，将所有 0 移动 到数组的 末尾 。
     * 例如，数组 [1,0,2,0,0,1] 将所有 0 移动到末尾后变为 [1,2,1,0,0,0] 。
     * 返回结果数组。
     */
    public static void main(String[] args) {
        int a[] = new int[]{312, 312, 436, 892, 0, 0, 528, 0, 686, 516, 0, 0, 0, 0, 0, 445, 445, 445, 445, 445, 445, 984, 984, 984, 0, 0, 0, 0, 168, 0, 0, 647, 41, 203, 203, 241, 241, 0, 628, 628, 0, 875, 875, 0, 0, 0, 803, 803, 54, 54, 852, 0, 0, 0, 958, 195, 590, 300, 126, 0, 0, 523, 523};
        new ApplyOperations().applyOperations(a);
    }

    public int[] applyOperations(int[] nums) {
        int[] result = new int[nums.length];
        int arr = 0;
        for (int x = 0; x < nums.length - 1; x++) {
            if (nums[x] == 0) {
                continue;
            }
            if (nums[x] == nums[x + 1]) {
                nums[x] *= 2;
                nums[x + 1] = 0;
            }
            result[arr++] = nums[x];
        }
        if (nums[nums.length - 1] != 0) {
            result[arr] = nums[nums.length - 1];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

}
