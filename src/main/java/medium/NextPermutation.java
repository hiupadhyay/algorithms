package medium;

import java.util.Arrays;

public class NextPermutation {

    /*
    Next permutation Algorithm:
    1.First find the first index i in numbers[] such that numbers[i-1]<numbers[i]
    2. store that number idx=i;
    3. Find minimum val numbers[j] in [ idx....numbers.length()] such that numbers[j-1]<numbers[j];
    4. store that in idx2=j;
    5. swap(numbers, idx,idx2);
    6.reverse the numbers from numbers[i] to numbers[numbers.length-1]
    7. if there is no such idx then reverse the entire num array.
    */
    public void nextPermutation(int[] numbers) {
        //step 1
        int firstMinimumIndex = -1;
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i - 1] < numbers[i]) {
                firstMinimumIndex = i - 1;
                break;
            }
        }
        //Check if no such number than return the sorted array.
        if (firstMinimumIndex == -1) {
            reverse(numbers, 0, numbers.length - 1);
        } else {
            //step 2
            int nearToFirstMinimum = 0;
            int nearToFirstMinimumIndex = 0;
            int fiirstMinimum = numbers[firstMinimumIndex];
            for (int j = firstMinimumIndex + 1; j <= numbers.length - 1; j++) {
                if (fiirstMinimum < numbers[j]) {
                    nearToFirstMinimum = Math.min(nearToFirstMinimum, numbers[j]);
                    nearToFirstMinimumIndex = j;
                }
            }
            //step3 swap
            swap(numbers, firstMinimumIndex, nearToFirstMinimumIndex);

            reverse(numbers, firstMinimumIndex + 1, numbers.length - 1);
        }
    }

    private void reverse(int[] nums, int start, int end) {
        int low = start;
        int high = end;
        while (low <= high) {
            swap(nums, low, high);
            low++;
            high--;
        }
    }

    private void swap(int[] nums, int low, int high) {
        int temp = nums[high];
        nums[high] = nums[low];
        nums[low] = temp;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation=new NextPermutation();
        int[] nums = new int[]{5,3,5,7,8,9};
        nextPermutation.nextPermutation(nums);
        for (int i : nums)
            System.out.print(i);
    }
}
