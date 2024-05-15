package medium;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author siianchan
 * @since 2024/5/13 15:09
 */
public class OrangesRotting {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new OrangesRotting().orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int count = 0;
        AtomicInteger good = new AtomicInteger(0);
        Set<String> jz2 = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    if (grid[i][j] == 1) {
                        good.getAndIncrement();
                    } else if (grid[i][j] == 2) {
                        jz2.add(i + "," + j);
                    }
                }
            }
        }
        if (good.get() == 0) {
            return 0;
        }
        if (jz2.isEmpty()) {
            return -1;
        }
        while (!jz2.isEmpty()) {
            //深搜
            count++;
            Set<String> newJz2 = new HashSet<>();
            jz2.forEach(tmp -> {
                int i = Integer.parseInt(tmp.split(",")[0]);
                int j = Integer.parseInt(tmp.split(",")[1]);
                List<String> gj = getGoodGz(grid, i, j);
                newJz2.addAll(gj);
                good.getAndAdd(-gj.size());
            });
            if(good.get()==0){
               break;
            }
            if (newJz2.isEmpty()) {
                //如果没有坏橘子新增，说明被空格阻断
                return -1;
            }
            jz2 = newJz2;
        }
        return count;
    }

    private List<String> getGoodGz(int[][] grid, int x, int y) {
        List<String> ret = new ArrayList<>();
        if (x - 1 >= 0) {
            if (grid[x - 1][y] == 1) {
                grid[x - 1][y] = 2;
                ret.add((x - 1) + "," + y);
            }
        }
        if (x + 1 < grid.length) {
            if (grid[x + 1][y] == 1) {
                grid[x + 1][y] = 2;
                ret.add((x + 1) + "," + y);
            }
        }
        if (y - 1 >= 0) {
            if (grid[x][y - 1] == 1) {
                grid[x][y - 1] = 2;
                ret.add(x + "," + (y - 1));
            }
        }
        if (y + 1 < grid[x].length) {
            if (grid[x][y + 1] == 1) {
                grid[x][y + 1] = 2;
                ret.add(x + "," + (y + 1));
            }
        }
        return ret;
    }

    private boolean checkBad(int[][] grid, int x, int y, Set<String> jz2) {
        //检测好橘子的四个方向是否有橘子
        if (x - 1 >= 0 && jz2.contains((x - 1) + "," + y)) {
            return true;
        }
        if (x + 1 < grid.length && jz2.contains((x + 1) + "," + y)) {
            return true;
        }
        if (y - 1 >= 0 && jz2.contains(x + "," + (y - 1))) {
            return true;
        }

        if (y + 1 < grid[x].length && jz2.contains(x + "," + (y + 1))) {
            return true;
        }
        return false;
    }
}
