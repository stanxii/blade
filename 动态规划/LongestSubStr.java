public class LongestSubStr {
    public static String LCS(String s1, String s2) {
        String res = "";
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return res;
        }
        int max = 0, m = s1.length(), n = s2.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0)
                        dp[i][j] = 1;
                    else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        res = s1.substring(i - max + 1, i + 1);
                    }
                }
            }
        }
        return res;
    }
}