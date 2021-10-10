package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/10/7 17:01
 * @Description:
 */
public class MaxProduct {
    int min = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -2, -2, -5};
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(arr));
    }

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }
}
