package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/7 16:46
 * @Description:
 */

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */

public class Exchange {
    public static void main(String[] args) {

    }

    public int[] exchange(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        //从左开始扫描，扫到偶数就从右开始扫描，直到扫描到奇数，然后两个数对换。然后继续扫描
        while (left < right) {
            if (nums[left] % 2 == 0) {
                while (left < right) {
                    if (nums[right] % 2 == 1) {
                        int temp = nums[left];
                        nums[left] = nums[right];
                        nums[right] = temp;
                        break;
                    }
                    right--;
                }
            }
            left++;
        }
        return nums;
    }
}
