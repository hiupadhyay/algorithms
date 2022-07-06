package practise.important;

public class UniquePaths {

    /**
     * @param m
     * @param n
     * @return Idea is to break it into sub-prroblems
     * when you are either at x,0 or 0,y there is 1 unique path to reach target.
     * else what if you are at x, y-1 and x-1, y position i.e two sub-problems to be solved.
     */
    public int recursive(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return recursive(m - 1, n) + recursive(m, n - 1);
    }

    public int recursiveDp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.recursive(3, 7));
        System.out.println(uniquePaths.recursiveDp(3, 7));

    }
}
