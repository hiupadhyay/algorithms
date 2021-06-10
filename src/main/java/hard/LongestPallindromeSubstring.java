package hard;

public class LongestPallindromeSubstring {

    public String longestPallindrome(String input) {
        int evenLen;
        int oddLen;
        int maxLen;
        int start = 0;
        int end = 0;
        for (int i = 0; i < input.length(); i++) {
            evenLen = expandFromMiddle(input, i, i);
            oddLen = expandFromMiddle(input, i, i + 1);
            maxLen = Math.max(oddLen, evenLen);
            if (maxLen > end - start) {
                //start would always be left side of i
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }

        }
        return input.substring(start, end + 1);
    }

    private int expandFromMiddle(String input, int left, int right) {
        while (left >= 0 && right <input.length() && input.charAt(left) == input.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LongestPallindromeSubstring longestPallindromeSubstring=new LongestPallindromeSubstring();
        System.out.println(longestPallindromeSubstring.longestPallindrome("abcabcbb"));
    }
}
