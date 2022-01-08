package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/1/8 16:37
 * @Description:
 */
public class ConstructArr {
    public static void main(String[] args) {

    }

    public int[] constructArr(int[] a) {
        if (a.length < 1) return a;
        int[] b = new int[a.length];
        b[0] = 1;
        for (int x = 1; x < a.length; x++) {
            b[x] = b[x - 1] * a[x - 1];
        }
        int temp = 1;
        for (int x = a.length - 1; x >= 0; x--) {
            b[x] = b[x] * temp;
            temp *= a[x];
        }
        return b;
    }
}
