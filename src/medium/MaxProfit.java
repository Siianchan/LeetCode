package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/1/7 15:58
 * @Description:
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = 0;
        for (int x = 0; x < prices.length; x++) {
            if (prices[x] < minValue) {
                minValue = prices[x];
            }
            if (prices[x] - minValue > maxValue) {
                maxValue = prices[x] - minValue;
            }
        }
        return maxValue;
    }
}
