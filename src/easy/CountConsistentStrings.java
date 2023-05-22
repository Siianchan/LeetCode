package easy;


import sun.security.krb5.internal.TGSReq;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class CountConsistentStrings {
    /**
     * 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。
     * 请你返回 words 数组中 一致字符串 的数目。
     * 示例 1：
     * 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
     * 输出：2
     * 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。
     */
    public static void main(String[] args) throws Exception {


        CountConsistentStrings c = new CountConsistentStrings();
        String[] words = new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"};
        System.out.println(c.countConsistentStrings("abc", words));

    }

    /*
        public int countConsistentStrings(String allowed, String[] words) {
            int num = 0;
            t1:
            for (int i = 0; i < words.length; i++) {
                char[] ch = words[i].toCharArray();
                for (int j = 0; j < ch.length; j++) {
                    if (!allowed.contains(String.valueOf(ch[j]))) {
                        continue t1;
                    }
                }
                num++;
            }
            return num;
        }
    */
    public int countConsistentStrings(String allowed, String[] words) throws Exception {
        //多线程头尾遍历
        CountDownLatch countDownLatch = new CountDownLatch(3);
        AtomicInteger num = new AtomicInteger();
        AtomicInteger l = new AtomicInteger(0);
        AtomicInteger r = new AtomicInteger(words.length - 1);
        int[] cCh = new int[26];
        for (int x = 0; x < allowed.length(); x++) cCh[(allowed.charAt(x) - 'A') % 26] = 1;
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while (r.intValue() > l.intValue()) {
                if (isCon(words[l.intValue()], cCh)) {
                    num.addAndGet(1);
                }
                l.getAndIncrement();
            }
            countDownLatch.countDown();
        }).start();
        System.out.println(111);
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            while (r.intValue() >= l.intValue()) {
                if (isCon(words[r.intValue()], cCh)) {
                    num.addAndGet(1);
                }
                r.getAndDecrement();
            }
            countDownLatch.countDown();
        }).start();
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        return num.intValue();
    }

    private boolean isCon(String word, int[] ch) {
        for (int i = 0; i < word.length(); i++) {
            if (ch[(word.charAt(i) - 'A') % 26] == 0) return false;
        }
        System.out.println(word);
        return true;
    }
}
