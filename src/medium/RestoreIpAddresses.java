package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/25 20:16
 * @Description:
 */
public class RestoreIpAddresses {
    /**
     * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
     * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
     * 输入：s = "25525511135"
     * 输出：["255.255.11.135","255.255.111.35"]
     */
    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses = new RestoreIpAddresses();
        restoreIpAddresses.restoreIpAddresses("1111");
    }

    List<String> list;

    public List<String> restoreIpAddresses(String s) {
        list = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return list;
        }
        int[] point = new int[3];
        dfs(point, 1, s);
        return list;
    }

    public void dfs(int[] p, int i, String str) {
        if (i == 4) {
            isTrue(p, str);
            return;
        }
        for (int x = 1; x <= 3; x++) {
            p[i - 1] = x;
            dfs(p, i + 1, str);
        }
    }

    public boolean isTrue(int[] p, String str) {
        String strc = new String(str);
        if ((str.length() - (p[0] + p[1] + p[2])) > 3) {
            return false;
        }
        if ((str.length() - (p[0] + p[1] + p[2])) <= 0) {
            return false;
        }
        String[] ipstr = new String[4];
        for (int x = 0; x < 4; x++) {
            if (x == 3) {
                ipstr[x] = strc;
            } else {
                ipstr[x] = strc.substring(0, p[x]);
                strc = strc.substring(p[x]);
            }
            if (Integer.valueOf(ipstr[x]) > 255) {
                return false;
            }
            if (ipstr[x].charAt(0) == '0' && ipstr[x].length() > 1) {
                return false;
            }
        }
        list.add(ipstr[0] + "." + ipstr[1] + "." + ipstr[2] + "." + ipstr[3]);
        return false;
    }
}
