package medium;


/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/3 13:48
 * @Description:
 */
public class JumpGame2 {
    /**
     * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     * 示例 1:
     * 输入: nums = [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     */
    static int ans = 0;
    public static void main(String[] args) {

        JumpGame2 jumpGame2 = new JumpGame2();
        int[] a = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 0};
//        [5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5]
//        int[] a=new int[]{2,3,1,1,4};
        System.out.println(jumpGame2.jump(a));
    }

    public int jump(int[] nums) {
        //动态规划，思路是算出到达每一步的最优解
        int[] ans = new int[nums.length];
        for (int x = 1; x < ans.length; x++) {
            ans[x] = Integer.MAX_VALUE;
        }
        for (int x = 0; x < nums.length - 1; x++) {
            int max=nums[x];
            for (int y = x + 1, z = 0; y < nums.length && z <max; z++, y++) {
                ans[y] = Math.min(ans[y], ans[x] + 1);
            }
        }
        return ans[ans.length - 1];
    }

}
