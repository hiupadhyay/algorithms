package practise.askedincompanies;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueChar {

    public Character firstUniqueCharacterWay1(String input) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : input.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        return freq.entrySet().stream().filter(m -> m.getValue() == 1).findFirst().map(Map.Entry::getKey).orElse(null);
    }


    public Character firstUniqueCharacterWay2(String input) {
        if (input.length() < 1) return null;
        int length = input.length();
        for (int i = 0; i < 26; i++) {
            int firstIndex = input.indexOf(i + 'a');
            if (firstIndex != -1) {
                int secondIndex = input.lastIndexOf(i + 'a');
                if (firstIndex == secondIndex) {
                    length = Math.min(length, firstIndex);
                }
            }
        }

        return length == input.length() ? null : input.charAt(length);

    }


    public static void main(String[] args) {
        FirstUniqueChar firstUniqueChar = new FirstUniqueChar();
        System.out.println(firstUniqueChar.firstUniqueCharacterWay1("aaaah"));
        System.out.println(firstUniqueChar.firstUniqueCharacterWay2("aaaah"));

    }
}
