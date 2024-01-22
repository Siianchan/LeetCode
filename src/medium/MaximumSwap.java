package medium;

/**
 * @author siianchan
 * @since 2024/1/22 09:29
 */
public class MaximumSwap {

    /**
     * 670. 最大交换
     * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
     * 示例 1 :
     * 输入: 2736
     * 输出: 7236
     * 解释: 交换数字2和数字7。
     * 示例 2 :
     * 输入: 9973
     * 输出: 9973
     * 解释: 不需要交换。
     * 注意:
     * 给定数字的范围是 [0, 108]
     */
    public static void main(String[] args) {
        System.out.println(new MaximumSwap().maximumSwap(993698));
    }

    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxIdx = n - 1;
        int idx1 = -1, idx2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (charArray[i] > charArray[maxIdx]) {
                maxIdx = i;
            } else if (charArray[i] < charArray[maxIdx]) {
                idx1 = i;
                idx2 = maxIdx;
            }
        }
        if (idx1 >= 0) {
            swap(charArray, idx1, idx2);
            return Integer.parseInt(new String(charArray));
        } else {
            return num;
        }
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    //暴力
    public int maximumSwap2(int num) {
        if (num == 0) {
            return 0;
        }
        char[] s = String.valueOf(num).toCharArray();
        tag1:
        for (int x = 0; x < s.length; x++) {
            int a = Integer.valueOf(s[x] - '0');
            if (a == 9) {
                continue;
            }
            int arr = -1;
            int max = -1;
            for (int y = s.length - 1; y > x; y--) {
                int b = Integer.valueOf(s[y] - '0');
                if (b > a) {
                    if (b == 9) {
                        char tmp = s[x];
                        s[x] = s[y];
                        s[y] = tmp;
                        break tag1;
                    }
                    if (b > max) {
                        //如果大于的话，记录坐标
                        max = b;
                        arr = y;
                    }
                }
            }
            if (arr != -1) {
                char tmp = s[x];
                s[x] = s[arr];
                s[arr] = tmp;
                break;
            }
        }
        return Integer.valueOf(String.valueOf(s));
    }
}
