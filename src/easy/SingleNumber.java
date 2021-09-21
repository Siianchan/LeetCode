package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/21 15:50
 * @Description:
 */
public class SingleNumber {
    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 说明：
     * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
     */

    public static void main(String[] args) {

    }

    public int singleNumber(int[] nums) {
        //异或法，两个相同数字异或后为0
        int num = 0;
        for (int i : nums
        ) {
            num ^= i;
        }
        return num;
    }
}
