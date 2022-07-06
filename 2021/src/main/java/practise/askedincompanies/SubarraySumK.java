package practise.askedincompanies;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumK {

    public static void main(String[] args) {
        int[] in = new int[]{1, -1, 0};
        int k = 1;
        printCountOfSubArraySumEqualsZero(in);
        printAllSubArraySumEqualsZero(in);
        printCountOfSubArraySumEqualsK(in, k);
        printAllSubArraySumEqualsK(in, k);
    }

    private static void printAllSubArraySumEqualsK(int[] in, int k) {
        prinAllOutput(getAllPairs(in, k), in);

    }

    private static void printCountOfSubArraySumEqualsK(int[] in, int k) {
        System.out.println("There are "+getAllPairs(in, k).size() + " subarrays with "+k+" sum");
    }

    private static void printAllSubArraySumEqualsZero(int[] in) {
        prinAllOutput(getAllPairs(in, 0), in);
    }

    private static void printCountOfSubArraySumEqualsZero(int[] in) {
        System.out.println("There are "+getAllPairs(in, 0).size() + " subarrays with zero sum");
    }

    private static List<Pair<Integer, Integer>> getAllPairs(int[] in, int k) {
        List<Pair<Integer, Integer>> output = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        for (int i = 0; i < in.length; i++) {
            sum += in[i];
            if (map.containsKey(sum - k)) {
                List<Integer> li = map.get(sum - k);
                for (Integer l : li)
                    output.add(new Pair<>(l + 1, i));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);

        }
        return output;
    }

    private static void prinAllOutput(List<Pair<Integer, Integer>> output, int[] in) {
        for (Pair<Integer, Integer> pair : output) {
            for (int i = pair.fst; i <= pair.snd; i++) {
                System.out.print(in[i] + "\t");
            }
            System.out.print("\n");
        }
    }
}
