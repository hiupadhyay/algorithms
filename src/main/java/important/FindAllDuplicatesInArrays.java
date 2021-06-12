package important;

import java.util.ArrayList;
import java.util.List;

/**
 * Note: Constraints are the array contains of only positive number
 */
public class FindAllDuplicatesInArrays {

    /**
     * @param nums
     * @return Idea of solving problem is
     * 1) You know the numbers in array are always numbers b/w start and endindex
     * 2) each number in array is pointing to index in array thus making a table.
     * 3) Now, we just need to figure out which value are mapped to multiple indexes
     * For example input arary [4,3,2,7,8,2,3,1]
     * Mapping with Indexes
     * 4 => 3
     * 3 => 2
     * 2 => 1
     * 7 => 6
     * 8 => 4
     * 2 => 5
     * 3 => 6
     * 1 => 7
     * if you see, [3,2] are the values which are mapped to multiple indexes thus duplicate.
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if (nums[idx - 1] < 0)
                output.add(idx);
            nums[idx - 1] = -nums[idx - 1];

        }
        return output;

    }

    public static void main(String[] args) {
        int[] in = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(in));
    }
}
