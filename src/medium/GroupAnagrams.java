package medium;

import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/8/7 14:56
 * @Description:
 */
public class GroupAnagrams {
    /**
     * 给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词指字母相同，但排列不同的字符串。
     * 示例 1:
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    public static void main(String[] args) {
        String[] strs = new String[]{""};
        GroupAnagrams anagrams = new GroupAnagrams();
        System.out.println(anagrams.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lists = new LinkedList<>();
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        for (int x = 0; x < strs.length; x++) {
            char[] ch = strs[x].toCharArray();
            Arrays.sort(ch); //因为是排列不同的字符串，所以对其进行排序后一定相等
            String str = String.valueOf(ch);
            //将排列后的当作key，将排列前的当作value值存入list集合中即可得出
            if (map.containsKey(str)) {
                map.get(str).add(strs[x]);
            } else {
                LinkedList<String> linkedList = new LinkedList<>();
                linkedList.add(strs[x]);
                map.put(str, linkedList);
            }
        }
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            lists.add(map.get(key));
        }
        return lists;
    }
}
