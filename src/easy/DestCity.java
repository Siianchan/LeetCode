package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author siianchan
 * @since 2024/10/8 13:28
 */
public class DestCity {
    /**
     * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，
     * 其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。
     * 请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
     * 题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
     * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
     * 输出："Sao Paulo"
     * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
     */
    public static void main(String[] args) {
        System.out.println(new DestCity().destCity(Arrays.asList(Arrays.asList("London", "New York")
                , Arrays.asList("New York", "Lima")
                , Arrays.asList("Lima", "Sao Paulo")
        )));
    }

    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> path : paths) {
            map.put(path.get(0), path.get(1));
        }
        //任意从一个点开始，直到找不到下一条路即为答案
        String search = paths.get(0).get(1);
        while (map.containsKey(search)) {
            search = map.get(search);
        }
        return search;
    }
}
