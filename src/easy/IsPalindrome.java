package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-05 18:24
 * @Description:
 */
public class IsPalindrome {
    /**
     * 回文数
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 示例 1:
     * 输入: 121
     * 输出:true
     */
    public static void main(String args[]) {
        System.out.println(isPalindrome(0));
    }
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(x));
        if (!stringBuilder.toString().equals(stringBuilder.reverse().toString())) {
            return false;
        }
        return true;
    }
}
