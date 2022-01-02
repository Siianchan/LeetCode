package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2022/1/2 14:43
 * @Description:
 */
public class ReverseWords {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        s = s.trim();
        String str[] = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int x = str.length - 1; x >= 0; x--) {
            if (str[x].trim().length() > 0) {
                stringBuilder.append(str[x].trim());
                if (x != 0) {
                    stringBuilder.append(" ");
                }
            }
        }
        return stringBuilder.toString();
    }
}
