package practise.medium;

import java.util.Arrays;

public class MinimumSubPath {

    public int minPathSumDP(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[i].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1)
                    dp[i][j] = grid[i][j];
                else if (i == dp.length - 1)
                    dp[i][j] = grid[i][j] + dp[i][j + 1];
                else if (j == dp[0].length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else
                    dp[i][j] = grid[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
            }
        }

        return dp[0][0];

    }


    public int minPathSumRecursiveUsingMemo(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return findPath(grid, grid.length - 1, grid[0].length - 1, memo);
    }

    private int findPath(int[][] grid, int m, int n, int[][] memo) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        if (m == 0 && n == 0)
            return grid[m][n];
        if (memo[m][n] != -1)
            return memo[m][n];
        memo[m][n] = grid[m][n] + Math.min(findPath(grid, m - 1, n, memo), findPath(grid, m, n - 1, memo));
        return memo[m][n];
    }


    public int minPathSumRecursion(int[][] grid) {
        //bottom up.... initially at m,n
        return findPath(grid, grid.length - 1, grid[0].length - 1);
    }

    private int findPath(int[][] grid, int m, int n) {
        if (m < 0 || n < 0)
            //ONLY Done to handle edge case.
            return Integer.MAX_VALUE;
        if (m == 0 && n == 0)
            return grid[m][n];
        return grid[m][n] + Math.min(findPath(grid, m - 1, n), findPath(grid, m, n - 1));

    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 2, 3
        }, {4, 5, 6}};
        MinimumSubPath minimumSubPath = new MinimumSubPath();
        System.out.println(minimumSubPath.minPathSumRecursion(grid));
        System.out.println(minimumSubPath.minPathSumRecursiveUsingMemo(grid));
        System.out.println(minimumSubPath.minPathSumDP(grid));


    }
}
