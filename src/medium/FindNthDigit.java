package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/12/18 16:59
 * @Description:
 */
public class FindNthDigit {
    public static void main(String[] args) {
        System.out.println(new FindNthDigit().findNthDigit(19));
    }

    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        int sum = 9;
        for (int x = 10; x <= n; x++) {
            String str = String.valueOf(x);
            if (sum + str.length() >= n) {
                return str.charAt(n - sum-1) - '0';
            }
            sum += str.length();// 11
        }
        return 0;
    }
}
