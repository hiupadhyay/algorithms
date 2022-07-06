package practise.medium;

public class ALLPallindromicSubString {

    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);
            count += expand(s, i, i + 1);
        }
        return count;
    }

    int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }
        return count;

    }

    public static void main(String[] args) {
        ALLPallindromicSubString pallindromicSubString=new ALLPallindromicSubString();
        System.out.println(pallindromicSubString.countSubstrings("abbba"));
    }
}
