package easy;

/**
 * @author siianchan
 * @since 2023/12/27 14:24
 */
public class IsWinner {
    public static void main(String[] args) {
        System.out.println(new IsWinner().isWinner(new int[]{10}, new int[]{1}));
    }

    public int isWinner(int[] player1, int[] player2) {
        int x = 0;
        int y = 0;
        int xD = -1;
        int yD = -1;
        for (int i = 0; i < player1.length; i++) {
            x += player1[i];
            y += player2[i];
            if (xD >= 0) {
                x += player1[i];
            }
            if (yD >= 0) {
                y += player2[i];
            }
            if (player1[i] == 10) {
                xD = 2;
            }
            if (player2[i] == 10) {
                yD = 2;
            }
            --xD;
            --yD;
        }
        return x > y ? 1 : x == y ? 0 : 2;
    }
}
