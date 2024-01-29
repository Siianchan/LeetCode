package hard;

import java.util.*;

/**
 * @author siianchan
 * @since 2024/1/29 13:40
 */
public class FindRotateSteps {
    /**
     * 514. 自由之路
     * 电子游戏“辐射4”中，任务 “通向自由” 要求玩家到达名为 “Freedom Trail Ring” 的金属表盘，并使用表盘拼写特定关键词才能开门。
     * 给定一个字符串 ring ，表示刻在外环上的编码；给定另一个字符串 key ，表示需要拼写的关键词。
     * 您需要算出能够拼写关键词中所有字符的最少步数。
     * 最初，ring 的第一个字符与 12:00 方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，
     * 然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
     * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
     * 您可以将 ring 顺时针或逆时针旋转 一个位置 ，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，
     * 并且这个字符必须等于字符 key[i] 。
     * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符
     * （下一阶段）, 直至完成所有拼写。
     * 输入: ring = "godding", key = "gd"
     * 输出: 4
     * 解释:
     * 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
     * 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
     * 当然, 我们还需要1步进行拼写。
     * 因此最终的输出是 4。
     */
    Map<Character, Set<Integer>> memoMap = new HashMap<>();
    int[][] memo;

    public static void main(String[] args) {
        System.out.println(new FindRotateSteps().findRotateSteps("caotmcaataijjxi", "oatjiioicitatajtijciocjcaaxaaatmctxamacaamjjx"));
//        System.out.println(new FindRotateSteps().findRotateSteps("godding", "godding"));
    }

    public int findRotateSteps(String ring, String key) {
        char[] ringCh = ring.toCharArray();
        char[] keyCh = key.toCharArray();
        //记忆化
        memo = new int[ring.length()][key.length()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        for (int i = 0; i < ringCh.length; i++) {
            //记录每个字符的坐标，为一个list
            Set hashSet = memoMap.getOrDefault(ringCh[i], new HashSet<>());
            hashSet.add(i);
            memoMap.put(ringCh[i], hashSet);
        }
        int max = dfs(0, 0, ringCh, keyCh);
        return max + key.length();
    }

    public int dfs(int keyArr, int ringArr, char[] ringC, char[] keyC) {
        int res = Integer.MAX_VALUE;
        if (keyArr == keyC.length) {
            //超出返回0
            return 0;
        }
        if (memo[ringArr][keyArr] != -1) {
            //记忆化搜索
            return memo[ringArr][keyArr];
        }
        //要比较的字符
        char ch = keyC[keyArr];
        for (int arr : memoMap.get(ch)) {
            //得到比较的字符下标数组，进行深搜
            int curCount;
            //判断顺时针还是逆时针
            int a = Math.abs(arr - ringArr);
            //算出两个坐标的差值为顺时针，逆时针就等于数组长度减去顺时针的差
            int b = ringC.length - a;
            //取最小的一个步数
            curCount = Math.min(a, b);
            //深搜
            res = Math.min(res, curCount + dfs(keyArr + 1, arr, ringC, keyC));
        }
        //保存一个子结果
        memo[ringArr][keyArr] = res;
        return res;
    }

}


//暴力解，超时
//    public void dfs(int keyArr, int ringArr, int count, char[] ringC, char[] keyC) {
//        System.out.println(keyArr + " " + ringArr);
//        if (count >= max) {
//            return;
//        }
//        if (keyArr == keyC.length) {
//            if (count < max) {
//                max = count;
//            }
//            return;
//        }
//        char ch = keyC[keyArr];
//        int count1 = 0;
//        int count2 = 0;
//        int ringArrL = ringArr;
//        int ringArrR = ringArr;
//        //往后转
//        while (ringC[ringArrL] != ch) {
//            count1++;
//            ringArrL++;
//            if (ringArrL == ringC.length) {
//                ringArrL = 0;
//            }
//        }
//        dfs(keyArr + 1, ringArrL, count + count1, ringC, keyC);
//        //往前转
//        while (ringC[ringArrR] != ch) {
//            count2++;
//            ringArrR--;
//            if (ringArrR == -1) {
//                ringArrR = ringC.length - 1;
//            }
//        }
//        dfs(keyArr + 1, ringArrR, count + count2, ringC, keyC);
//    }
//
