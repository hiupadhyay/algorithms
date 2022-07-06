package practise.medium;

import java.util.ArrayList;
import java.util.List;

public class AllPermutations {

    private List<List<Integer>> output = new ArrayList<List<Integer>>();


    public static void main(String[] args) {
        AllPermutations permutations = new AllPermutations();
        System.out.println(permutations.permute(new int[]{1, 2, 3}));
    }


    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ds = new ArrayList<Integer>();
        boolean[] freq = new boolean[nums.length];
        recur(nums, ds, freq);
        return output;

    }

    private void recur(int[] nums, List<Integer> ds, boolean[] freq) {
        if (ds.size() == nums.length) {
            output.add(new ArrayList<Integer>(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                ds.add(nums[i]);
                recur(nums, ds, freq);
                ds.remove(ds.size() - 1);
                freq[i] = false;
            }
        }
    }


}
