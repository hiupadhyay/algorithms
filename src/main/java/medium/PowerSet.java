package medium;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public List<List<Integer>> getPowerSet(int[] input) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int i : input) {
            int size = output.size();
            for (int j = 0; j < size; j++) {
                //we should make deep-copy
                List<Integer> subset = new ArrayList<>(output.get(j));
                subset.add(i);
                output.add(subset);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        PowerSet powerSet = new PowerSet();
        System.out.println(powerSet.getPowerSet(input));

    }
}
