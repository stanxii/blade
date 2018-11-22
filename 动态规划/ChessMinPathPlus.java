// 动态规划利用滚动数组求棋盘最小路径和

public class ChessMinPathPlus {
    public static int minPath(int[][] chess) {
        int row = chess.length;
        int col = chess[0].length;
        int[] dp = new int[col];
        dp[0] = chess[0][0];
        for (int j = 1; j < col; j++)
            dp[j] = dp[j - 1] + chess[0][j];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0)
                    dp[j] += chess[i][j];
                else
                    dp[j] = (dp[j] < dp[j - 1] ? dp[j] : dp[j - 1]) + chess[i][j];
            }
        }
        return dp[col - 1];
    }

    public static void main(String[] args) {
        int[][] chess = { { 7, 3, 4 }, { 8, 12, 3 }, { 6, 9, 20 } };
        System.out.println(minPath(chess));
    }
}