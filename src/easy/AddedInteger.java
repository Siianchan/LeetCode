package easy;

/**
 * @author siianchan
 * @since 2024/8/8 10:56
 */
public class AddedInteger {
    /**
     * 输入：nums1 = [2,6,4], nums2 = [9,7,5]
     * 输出：3
     * 解释：
     * 与 3 相加后，nums1 和 nums2 相等。
     * 给你两个长度相等的数组 nums1 和 nums2。
     * 数组 nums1 中的每个元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
     * 在与 x 相加后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
     * 返回整数 x 。
     */


    public static void main(String[] args) {

    }

    public int addedInteger(int[] nums1, int[] nums2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int n = 0; n < nums1.length; n++) {
            sum1 += nums1[n];
            sum2 += nums2[n];
        }
        return (sum2 - sum1) / nums1.length;
    }
}
