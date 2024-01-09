package medium;

import java.util.*;


/**
 * @author siianchan
 * @since 2023/11/30 13:53
 */
public class CloseStrings {
    public static void main(String[] args) {
        System.out.println(new CloseStrings().closeStrings("uau", "ssx"));
    }

    public boolean closeStrings(String word1, String word2) {
        Map<Character, Integer> wMap1 = new HashMap<>();
        Map<Character, Integer> wMap2 = new HashMap<>();
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] c1 = word1.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            wMap1.put(c1[i], wMap1.getOrDefault(c1[i], 0) + 1);
        }
        char[] c2 = word2.toCharArray();
        for (int i = 0; i < c2.length; i++) {
            wMap2.put(c2[i], wMap2.getOrDefault(c2[i], 0) + 1);
        }
        List<Integer> list = new ArrayList<>(wMap1.values());
        List<Integer> list2 = new ArrayList<>(wMap2.values());
        Collections.sort(list);
        Collections.sort(list2);
        return list.toString().equals(list2.toString());
    }
}
