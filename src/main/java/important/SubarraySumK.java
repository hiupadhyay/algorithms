package important;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumK {

    public static void main(String[] args) {
        int[] in = new int[]{1, 2, 3};
        int k = 3;
        int i = new SubarraySumK().getTotalSubArrays(in, k);
        System.out.print(i);
    }

    private int getTotalSubArrays(int[] in, int k) {
            int count = 0;
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0,1);
            for (int i : in) {
                sum += i;
                if (map.containsKey(sum - k))
                    count += map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
    }
}
