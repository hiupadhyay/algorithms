package practise.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestPallindrome {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> lookup = new HashSet<>();
        int slow = 0;
        int fast = 0;
        int max = 0;
        while (fast < s.length()) {

            if (!lookup.contains(s.charAt(fast))) {
                lookup.add(s.charAt(fast));
                max = Math.max(max, lookup.size());
                fast++;
            } else {
                lookup.remove(s.charAt(slow));
                slow++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestPallindrome pallindrome = new LongestPallindrome();
        System.out.println(pallindrome.lengthOfLongestSubstring("abcabcxzyh"));
    }
}
