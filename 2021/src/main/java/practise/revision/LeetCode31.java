package practise.revision;

public class LeetCode31 {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        LeetCode31 leetCode31 = new LeetCode31();
        leetCode31.nextPermutation(input);
        leetCode31.printInput(input);
    }

    private void nextPermutation(int[] nums) {
        int firstIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                firstIndex = i - 1;
                break;
            }
        }

        if (firstIndex == -1) {
            reverse(nums, 0, nums.length - 1);
        } else {
            int secondIndex = 0;
            for (int j = firstIndex + 1; j < nums.length; j++) {
                if (nums[firstIndex] < nums[j]) {
                    secondIndex = j;
                }
            }
            swap(nums, firstIndex, secondIndex);
            reverse(nums, firstIndex + 1, nums.length - 1);
        }
    }

    private void swap(int[] nums, int firstIndex, int secondIndex) {
        int temp = nums[secondIndex];
        nums[secondIndex] = nums[firstIndex];
        nums[firstIndex] = temp;
    }

    private void reverse(int[] nums, int low, int high) {
        while (low <= high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    private void printInput(int[] input) {
        for (int i : input)
            System.out.print(i + "\t");
    }
}
