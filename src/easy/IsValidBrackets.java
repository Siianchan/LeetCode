package easy;


/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2019-12-03 19:31
 * @Description:
 */
public class IsValidBrackets {
    /**
     * 有效的括号
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     * 示例 1:
     * 输入: "()"
     * 输出: true
     */
    public static void main(String args[]) {
        System.out.println(isValid("{[]}"));
    }

    public static boolean isValid(String s) {
        String left = "({[";
        if (s.trim().length() <= 0) {
            //如果是空字符串，返回true
            return true;
        }
        char[] chs = s.toCharArray();
        for (int x = 0; x < chs.length; x++) {
            String str = String.valueOf(chs[x]);
            //当检测到左括号就向下搜寻
            if (left.contains(str)) {
                continue;
            } else {
                //当检测到右括号就进入
                if (x == 0) {
                    //当右括号是第一个时，返回false
                    return false;
                }
                for (int y = x - 1; y >= 0; y--) {
                    if (chs[y] == 0) {
                        //如果该字符已消除，进入下一层循环
                        continue;
                    } else if (Math.abs(chs[x] - chs[y]) < 5) {
                        //如果是未消除的字符串，并且匹配成功，则进入下一个右括号搜寻并消除匹配的字符串
                        chs[x] = 0;
                        chs[y] = 0;
                        break;
                    } else {
                        //如果不匹配，则返回false
                        return false;
                    }
                }
            }
        }
        for (int x = 0; x < chs.length; x++) {
            //如果全部都执行完成后，还有字符串未消除，则返回false
            if (chs[x] != 0) {
                return false;
            }
        }
        return true;
    }
}
