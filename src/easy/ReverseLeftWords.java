package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/1/3 14:33
 * @Description:
 */
public class ReverseLeftWords {
    public static void main(String[] args) {

    }

    public String reverseLeftWords(String s, int n) {
        String str = s.substring(0, n);
        String str2 = s.substring(n);
        return str2 + str;
    }
}
