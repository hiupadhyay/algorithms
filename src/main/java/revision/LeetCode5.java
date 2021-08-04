package revision;

public class LeetCode5 {
    /**
     * Find longest substring and it's length
     */

    public static void main(String[] args) {
        String input = "aba";
        System.out.println(longestPalindromeN3(input));
        System.out.println(longestPalindromeN2(input));
    }

    private static String longestPalindromeN3(String input) {
        int maxLen = 0;
        String s = "";
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String t = input.substring(i, j);
                int length = t.length();
                if (isPallindrome(t) && length > maxLen) {
                    maxLen = length;
                    s = t;
                }
            }
        }
        return s;
    }

    private static boolean isPallindrome(String sub) {
        int start = 0;
        int end = sub.length() - 1;
        while (start <= end) {
            if (sub.charAt(start++) != sub.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    private static String longestPalindromeN2(String input) {
        int start = 0;
        int end = 0;
        int len;

        for (int i = 0; i < input.length(); i++) {
            int len1 = expandFromMiddle(input, i, i);
            int len2 = expandFromMiddle(input, i, i + 1);
            len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return input.substring(start, end + 1);
    }

    private static int expandFromMiddle(String input, int left, int right) {
        int R = right;
        int L = left;
        while (L >= 0 && R < input.length() && input.charAt(L) == input.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


}
