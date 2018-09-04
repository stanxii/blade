class ChessMinPath {
    public static int minPath(int[][] chess) {
        int row = chess.length;
        int col = chess[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = chess[0][0];
        for (int i = 1; i < row; i++)
            dp[i][0] = dp[i - 1][0] + chess[i][0];
        for (int j = 1; j < col; j++)
            dp[0][j] = dp[0][j - 1] + chess[0][j];
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = (dp[i - 1][j] < dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1]) + chess[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int[][] chess = { { 7, 3, 4 }, { 8, 12, 3 }, { 6, 9, 20 } };
        System.out.println(minPath(chess));
    }
}