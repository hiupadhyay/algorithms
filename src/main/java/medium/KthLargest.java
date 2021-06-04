package medium;

public class KthLargest {

    /**
     * @param nums
     * @param k
     * @return
     * @info Idea of bubble sort is that at each pass it brings the highest element at the last.
     * so if i have to find 1st highest element i would get it in single iteration, if i want 2nd highest
     * i will get it under two iterations like that. i worst case i have to run n passes.
     * Complexity would be O(N*K) worst case where N==K , O(N^2)
     */
    public int findKthLargestUsingBubbleSort(int[] nums, int k) {
        int pass = 1;
        int start = 0;
        int end = nums.length - 1;
        while (pass <= k) {
            for (int i = start; i <= end - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = temp;
                }
            }
            end = end - 1;
            pass++;
        }
        return nums[nums.length - k];
    }

    /**
     * @param nums
     * @param k
     * @return
     * @Info
     */
    public int findKthLargestUsingPartition(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        //Index is a place where we are expected to find our element.
        int index = nums.length - k;
        while (start < end) {
            int pivot = partition(nums, start, end);
            //it means the element is on right side of pivot...
            if (pivot < index) {
                start = pivot + 1;
            } else if (pivot > index) {
                end = pivot - 1;
            } else {
                return nums[pivot];
            }
        }
        //if pivot is not found till the very end...worst case it would be the  element at start index.
        return nums[start];
    }

    //partitions main purpose it to make sure that at each pass the left side
    //of pivot should be less than pivot and right > than pivot
    private int partition(int[] nums, int start, int end) {
        int pivot = start;
        int temp = 0;
        while (start <= end) {
            //the below two lines are narrowing down the start and end window such that
            //pivot lies b/w start and end... and start are low than pivot till the point and end are
            //high than pivot till the point
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            //to protect overflow from previous
            if (start > end) break;
            //if code reaches this line it means nums[start]>nums[end]
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        //this means the element at end at a single pass is the pivot...
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        pivot = end;
        return pivot;
    }

    public static void main(String[] args) {

        KthLargest largest = new KthLargest();
        int[] in = new int[]{2, 1};
        System.out.println(largest.findKthLargestUsingPartition(in, 1));

    }


}
