package medium;

/**
 * @ProjectName: LeetCode
 * @Author: ZhangXiangQiang
 * @Create: 2021/9/20 13:45
 * @Description:
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {

    }

    int startNum = -1;

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length<=1){
            if(gas[0]>=cost[0])return 0;
            else return -1;
        }
        for (int x = 0; x < gas.length; x++) {
            if (gas[x] >= cost[x]) {
                dfs(gas, cost, x, x + 1, gas[x] - cost[x]);
                if (startNum != -1) break;
            }
        }
        return startNum;
    }

    public void dfs(int[] gas, int[] cost, int start, int arr, int qy) {
        if (arr >= gas.length) arr = 0;
        if (arr == start) {
            startNum = start;
            return;
        }
        if (qy + gas[arr] >= cost[arr]) {
            dfs(gas, cost, start, arr + 1, (qy + gas[arr]) - cost[arr]);
        }
        return;
    }
}
