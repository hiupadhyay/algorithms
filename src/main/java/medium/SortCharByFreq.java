package medium;

import java.util.*;
import java.util.stream.Collectors;

public class SortCharByFreq {


    public static void main(String[] args) {
        String input = "tree";
        System.out.println(SortCharByFreq.sortByFreq(input));
    }

    private static String sortByFreq(String input) {
        Map<Character, Integer> f = new HashMap<>();
        for (char c : input.toCharArray()) {
            if (f.containsKey(c)) {
                f.put(c, f.get(c) + 1);
            } else {
                f.put(c, 1);
            }
        }
        Map<Character, Integer> re = f.entrySet().
                stream().
                sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oval, nval) ->
                        oval, LinkedHashMap::new
                ));
        StringBuilder st = new StringBuilder();
        re.forEach((k, v) -> {
            while (v > 0) {
                st.append(k);
                v--;
            }
        });

        return st.toString();
    }
}
