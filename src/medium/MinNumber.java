package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/19 19:43
 * @Description:
 */

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class MinNumber {

    public static void main(String[] args) {
        MinNumber minNumber = new MinNumber();
        int[] num = new int[]{2, 1, 2, 0};
        minNumber.minNumber(num);
    }

    public String minNumber(int[] nums) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (aIsMax(nums[j], nums[j + 1])) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int x = 0; x < nums.length; x++) {
            s.append(nums[x]);
        }
        return s.toString();
    }

    public boolean aIsMax(int a, int b) {
        
        String s1 = "" + a;
        String s2 = "" + b;
        for (int x = 0; x < s1.length() && x < s2.length(); x++) {
            char c1 = s1.charAt(x);
            char c2 = s2.charAt(x);
            if (c1 < c2) {
                return false;
            } else if (c1 > c2) {
                return true;
            }
            if (x + 1 == s1.length() || x + 1 == s2.length()) {
                if (s1.length() == s2.length()) {
                    break;
                }
                if (x + 1 >= s1.length()) {
                    return s2.charAt(x + 1) >= s1.charAt(0) ? false : true;
                }
                if (x + 1 >= s2.length()) {
                    return s1.charAt(x + 1) >= s2.charAt(0) ? true : false;
                }

            }
        }
        return false;
    }
}
