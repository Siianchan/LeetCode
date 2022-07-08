package easy;


/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/7/8 15:52
 * @Description:
 */
public class MinCostToMoveChips {
    /**
     * 有 n 个筹码。第 i 个筹码的位置是 position[i] 。
     * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
     * position[i] + 2 或 position[i] - 2 ，此时 cost = 0
     * position[i] + 1 或 position[i] - 1 ，此时 cost = 1
     * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
     */

    public int minCostToMoveChips(int[] position) {
        //意思是，同为奇数或偶数之间移动不需要消耗代价，意味着，奇数移动到同一个，偶数移动到同一个的cost都为0，最后只需要看那边更小，直接移动
        int j = 0;
        int o = 0;
        for (int i : position
        ) {
            if (i % 2 == 0) o++;
            else j++;
        }
        return Integer.min(j, o);
    }

    public static void main(String[] args) {
        System.out.println(new MinCostToMoveChips().minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
    }
}
