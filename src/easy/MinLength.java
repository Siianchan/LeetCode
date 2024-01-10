package easy;

import java.util.ArrayDeque;

/**
 * @author siianchan
 * @since 2024/1/10 09:37
 */
public class MinLength {
    /**
     * 给你一个仅由 大写 英文字符组成的字符串 s 。
     * 你可以对此字符串执行一些操作，在每一步操作中，你可以从 s 中删除 任一个 "AB" 或 "CD" 子字符串。
     * 通过执行操作，删除所有 "AB" 和 "CD" 子串，返回可获得的最终字符串的 最小 可能长度。
     * 注意，删除子串后，重新连接出的字符串可能会产生新的 "AB" 或 "CD" 子串。
     */
    public static void main(String[] args) {
        minLength("ACBBD");
    }

    public static int minLength(String s) {
        ArrayDeque<Character> deque = new ArrayDeque();
        for (char c : s.toCharArray()) {
            if (deque.size() > 0) {
                //每当栈里的数量达到了1
                if ((deque.peek() == 'A' && c == 'B') || (deque.peek() == 'C' && c == 'D')) {
                    deque.pop();
                    continue;
                }
            }
            deque.push(c);
        }
        return deque.size();
    }
}
