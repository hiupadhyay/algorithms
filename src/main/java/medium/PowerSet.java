package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerSet {


    public List<List<Integer>> getPowerSet_2(int[] input) {
        List<List<Integer>> output = new ArrayList<>();
        int start = 0;
        int end = (int) Math.pow(2, input.length);
        for (int i = start; i < end; i++) {
            List<Integer> subset = new ArrayList<>();
            int temp = i;
            for (int j = input.length - 1; j >= 0; j--) {
                int r = temp % 2;
                temp = temp / 2;
                if (r != 0) {
                    subset.add(input[j]);
                }
            }
            output.add(subset);
        }
        return output;
    }


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
        //System.out.println(Arrays.toString(powerSet.getBinary(4)));
        System.out.println(powerSet.getPowerSet_2(input));

    }
}
