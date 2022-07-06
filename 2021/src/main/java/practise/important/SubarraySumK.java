package practise.important;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumK {

    public static void main(String[] args) {
        int[] in = new int[]{1, -1, 0};
        int k = 0;
        int i = new SubarraySumK().getTotalSubArrays(in, k);
        //System.out.println(i);
        List<Pair<Integer, Integer>> output = new SubarraySumK().printAllSubArrays(in, k);
        System.out.print(output.size());
        prinAllOutput(output, in);
    }

    private static void prinAllOutput(List<Pair<Integer, Integer>> output, int[] in) {
        for (Pair<Integer, Integer> pair : output) {
            for (int i = pair.fst; i <= pair.snd; i++) {
                System.out.print(in[i] + "\t");
            }
            System.out.print("\n");
        }
    }

    //6, 3, -1, -3, 4, -2, 2,
//                4, 6, -12, -7
    private List<Pair<Integer, Integer>> printAllSubArrays(int[] in, int k) {
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
            if(!map.containsKey(sum))
            {
                map.put(sum, new ArrayList<>());
            }
            map.get(sum).add(i);

        }
        return output;
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
