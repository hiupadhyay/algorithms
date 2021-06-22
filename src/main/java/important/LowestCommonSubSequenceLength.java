package important;

import java.util.Arrays;

public class LowestCommonSubSequenceLength {

    //way 1.
    public int longestCommonSubsequenceRecursion(String text1, String text2) {
        return recursion(text1, text2, 0, 0);
    }

    public int recursion(String text1, String text2, int i, int j) {
        if (i > text1.length() - 1 || j > text2.length() - 1)
            return 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + recursion(text1, text2, i + 1, j + 1);
        } else {
            return Math.max(recursion(text1, text2, i + 1, j), recursion(text1, text2, i, j + 1));
        }
    }


    //way 2
    public int longestCommonSubsequenceUsingMemoization(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return recursionUsingMemo(text1, text2, dp, 0, 0);
    }

    public int recursionUsingMemo(String text1, String text2, int[][] dp, int i, int j) {
        if (i > text1.length() - 1 || j > text2.length() - 1)
            return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + recursionUsingMemo(text1, text2, dp, i + 1, j + 1);
        } else {
            dp[i][j] = Math.max(recursionUsingMemo(text1, text2, dp, i + 1, j),
                    recursionUsingMemo(text1, text2, dp, i, j + 1));
        }
        return dp[i][j];
    }

    public int longestCommonSubsequenceUsingDP(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public String longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        StringBuilder st = new StringBuilder();
        for (int i = 1; i < dp.length; i++)
            for (int j = 1; j < dp[i].length; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    st.append(text1.charAt(i-1));
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

       int index=dp[text1.length()][text2.length()];
            char [] output=new char[index];
        int i = text1.length(), j = text2.length();
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                output[index-1] = text1.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }
        return new String(output);
    }


    public static void main(String[] args) {
        LowestCommonSubSequenceLength lowestCommonSubSequenceLength = new LowestCommonSubSequenceLength();
        System.out.println(lowestCommonSubSequenceLength.longestCommonSubsequenceUsingDP("abcde", "ace"));
        System.out.println(lowestCommonSubSequenceLength.longestCommonSubsequence("abcde", "ace"));

    }
}
