package important;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumK {

    public static void main(String[] args) {
        int[] in = new int[]{6, 3, -1, -3, 4, -2, 2,
                4, 6, -12, -7};
        int k = 0;
        int i = new SubarraySumK().getTotalSubArrays(in, k);
        //System.out.println(i);
        new SubarraySumK().printAllSubArrays(in, k);
    }

    private void printAllSubArrays(int[] in, int k) {
        int sum = 0;
        Map<Integer, List<Integer>> lookup = new HashMap<>();
        List<Pair<Integer, Integer>> pair = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(0);
        lookup.put(0, li);
        for (int i = 0; i < in.length; i++) {
            sum += in[i];
            if (lookup.containsKey(sum - k)) {
                lookup.get(sum - k).add(i);
                for (int el : lookup.get(sum - k)) {
                    pair.add(new Pair<>(el + 1, i));
                }
            } else {
                List<Integer> li1 = new ArrayList<>();
                li1.add(i);
                lookup.put(sum, li1);
            }
        }
        pair.forEach((p) -> printSubArray(in, p.fst, p.snd));
    }

    private void printSubArray(int[] in, int start, int end) {
        while (start <= end) {
            System.out.print(in[start] + "\t");
            start++;
        }
        System.out.println();

    }

    private int getTotalSubArrays(int[] in, int k) {
        int count = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i : in) {
            sum += i;
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
