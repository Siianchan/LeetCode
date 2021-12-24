package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/23 15:08
 * @Description:
 */
public class Search {
    public static void main(String[] args) {
        Search search = new Search();
        int[] nums = new int[]{2, 2};
        System.out.println(search.search(nums, 1));
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int index = findIndex(nums, target, 0, nums.length - 1);
        if (index < 0) {
            return 0;
        }
        int sum = 1;
        for (int x = index - 1; x >= 0; x--) {
            if (nums[x] == target) {
                sum++;
            } else {
                break;
            }
        }
        for (int x = index + 1; x < nums.length; x++) {
            if (nums[x] == target) {
                sum++;
            } else {
                break;
            }
        }
        System.out.println(sum);
        return sum;
    }

    public int findIndex(int[] nums, int target, int start, int end) {
        int index = (start + end) / 2;
        if (nums[index] == target) {
            return index;
        }
        if (start >= end) {
            return -1;
        }
        if (nums[index] > target) {
            return findIndex(nums, target, start, index - 1);
        }
        if (nums[index] < target) {
            return findIndex(nums, target, index + 1, end);
        }
        return -1;
    }
}
