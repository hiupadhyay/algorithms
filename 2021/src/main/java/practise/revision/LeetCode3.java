package practise.revision;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {
    /**
     * Find longest substring and it's length
     */

    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println(longestSubString(input));
    }

    private static String longestSubString(String input) {
        Set<Character> lookup = new HashSet<>();
        int fast = 0;
        int max = 0;
        int slow = 0;
        String output = "";
        while (fast < input.length()) {
            if (!lookup.contains(input.charAt(fast))) {
                lookup.add(input.charAt(fast++));
                if (lookup.size() > max) {
                    max = lookup.size();
                    output = Arrays.toString(lookup.toArray());
                }
            } else {
                lookup.remove(input.charAt(slow++));
            }
        }
        return output;
    }
}
