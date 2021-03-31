package cn.year2021.test;/**
 * @author chy
 * @date 2021/3/31 0031 下午 14:55
 * Description：
 */

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/3/31 0031
 */
public class MXNChessboard {

    public static void main(String[] args) {
        System.out.println(getPath(5, 10));
        getPath2(5, 10);
    }

    public static int getPath(int n, int m) {
        if (n == 0 || m == 0) {
            return 1;
        }
        return getPath(n - 1, m) + getPath(n, m - 1);
    }

    public static void getPath2(int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
//                System.out.println(dp[i][j]);
            }
        }
        System.out.println(dp[n][m]);
    }
}
