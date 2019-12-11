package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-11 15:25
 * @Description:
 */
public class LongestPalindrome {
    /**
     * 最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案
     */
    public static void main(String args[]) {
        System.out.println(longestPalindrome(""));
    }

    public static String longestPalindrome(String s) {
        String finalString = new String();
        char[] chs = s.toCharArray();
        for (int x = 0; x < chs.length; x++) {
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder.append(String.valueOf(chs[x]));
            boolean flag = false;
            int a = x - 1;
            int b = x + 1;
            int d = x + 2;
            if (x < chs.length - 1 && chs[x] == chs[x + 1]) {
                //如果下一个字符与这个字符相等，开启偶数回文串循环
                stringBuilder2.append(String.valueOf(chs[x + 1]));
                stringBuilder2.append(String.valueOf(chs[x]));
                flag = true;
            }
            while (a >= 0 && b < chs.length) {
                boolean isBreak = true;
                if (flag && d < chs.length && chs[a] == chs[d]) {
                    //偶数回文串循环
                    isBreak = false;
                    stringBuilder2.insert(0, chs[a]);
                    stringBuilder2.append(chs[d]);
                    d++;
                }
                if (chs[a] == chs[b]) {
                    isBreak = false;
                    stringBuilder.insert(0, chs[a]);
                    stringBuilder.append(chs[a]);
                    b++;
                }
                a--;
                if (isBreak) {
                    break;
                }
            }
            if (stringBuilder.length() > finalString.length()) {
                finalString = stringBuilder.toString();
            }
            if (stringBuilder2.length() > finalString.length()) {
                finalString = stringBuilder2.toString();
            }
        }
        return finalString;
    }
}

/**
 * if (s.equals(""))
 * return "";
 * String origin = s;
 * String reverse = new StringBuffer(s).reverse().toString();
 * int length = s.length();
 * int[] arr = new int[length];
 * int maxLen = 0;
 * int maxEnd = 0;
 * for (int i = 0; i < length; i++)
 * for(int j=length-1;j>=0;j--){
 * if(origin.charAt(i)==reverse.charAt(j)){
 * if(i==0||j==0){
 * arr[j]=1;
 * }else{
 * arr[j]=arr[j-1]+1;
 * }
 * //之前二维数组，每次用的是不同的列，所以不用置 0 。
 * }else{
 * arr[j]=0;
 * }
 * if(arr[j]>maxLen){
 * int beforeRev=length-1-j;
 * if(beforeRev+arr[j]-1==i){
 * maxLen=arr[j];
 * maxEnd=i;
 * }
 * }
 * }
 * return s.substring(maxEnd-maxLen+1,maxEnd+1);
 */

