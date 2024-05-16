package medium;


/**
 * @author siianchan
 * @since 2024/5/16 11:30
 */
public class FindWhetherExistsPath {
    /**
     * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
     * 示例1:
     * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
     * 输出：true
     * 示例2:
     * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]],
     * start = 0, target = 4
     * 输出 true
     */
    public static void main(String[] args) {
        int graph[][] = new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        //从终点往前步步压缩
        new FindWhetherExistsPath().findWhetherExistsPath(3, graph, 0, 3);
    }

    // 访问状态数组
    private boolean[] visited = null;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        // 创建访问状态数组
        this.visited = new boolean[graph.length];
        // DFS
        return helper(graph, start, target);
    }

    private boolean helper(int[][] graph, int start, int target) {
        // 深度优先搜索
        for (int i = 0; i < graph.length; ++i) {
            // 确保当前路径未被访问（该判断主要是为了防止图中自环出现死循环的情况）
            if (!visited[i]) {
                // 若当前路径起点与终点相符，则直接返回结果
                if (graph[i][0] == start && graph[i][1] == target) {
                    return true;
                }
                // 设置访问标志
                visited[i] = true;
                // DFS关键代码，思路：同时逐渐压缩搜索区间
                if (graph[i][1] == target && helper(graph, start, graph[i][0])) {
                    return true;
                }
                // 清除访问标志
                visited[i] = false;
            }
        }
        return false;
    }
}
