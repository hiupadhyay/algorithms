package revision;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {

    List<List<String>> output = new ArrayList<>();

    List<List<String>> allPermutations(String input) {
        List<String> ds = new ArrayList<>();
        boolean[] isVisited = new boolean[input.length()];
        backTrack(input, ds, isVisited);
        return output;
    }

    private void backTrack(String input, List<String> ds, boolean[] isVisited) {
        if (ds.size() == input.length()) {
            output.add(new ArrayList<>(ds));
        }
        for (int i = 0; i < input.length(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                ds.add(String.valueOf(input.charAt(i)));
                backTrack(input, ds, isVisited);
                ds.remove(ds.size() - 1);
                isVisited[i] = false;
            }
        }

    }


    public static void main(String[] args) {
        LeetCode46 leetCode46 = new LeetCode46();
        System.out.println(leetCode46.allPermutations("123"));
    }
}
