package practise.important;

/**
 * Note this algo is based on Cycle detection algo
 * Idea is to get a first overlap due to cycle.
 * Once we have overlap we run both fast and slow pace where they reach it means cycle starts there.
 */
public class FindDuplicateNumberWithModifiyingArrray {


    public static void main(String[] args) {
        FindDuplicateNumberWithModifiyingArrray find = new FindDuplicateNumberWithModifiyingArrray();
        int[] input = new int[]{1, 3, 4, 2, 2,
        };

        System.out.println(find.findCycle(input));
    }

    private int findCycle(int[] nums) {
        if (nums.length < 1) return -1;
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //we found the overlap...
        fast = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
