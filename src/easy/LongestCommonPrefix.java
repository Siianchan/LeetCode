package easy;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-09 16:49
 * @Description:
 */
public class LongestCommonPrefix {
    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1:
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     */
    public static void main(String args[]) {
        String[] strs=new String[]{"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
    }
    public  static  String longestCommonPrefix(String[] strs) {
            String str="";
            if(strs.length<1){
                return str;
            }
            char[] chs=strs[0].toCharArray();
            for(int x=0;x<chs.length;x++){
                for(int y=1;y<strs.length;y++){
                    char[] ch=strs[y].toCharArray();
                    if(x>=ch.length||chs[x]!=ch[x]){
                        return str;
                    }
                }
                str+=String.valueOf(chs[x]);
            }
            return str;
    }
}
