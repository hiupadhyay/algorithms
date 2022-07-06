package practise.medium;

public class SortColors {

    public void sortColors(int[] nums) {
        // low =0, mid=1, high=2
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while (mid <= high) {
            int n = nums[mid];
            if (n == 0) {
                swap(nums, low++, mid++);
            } else if (n == 1) {
                mid++;
            } else {
                //n==2
                swap(nums, mid, high--);
            }
        }

    }

    public void swap(int[] arr, int r1, int r2) {
        int temp = arr[r2];
        arr[r2] = arr[r1];
        arr[r1] = temp;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{2, 0, 2, 1, 1, 0};
        SortColors colors = new SortColors();
        colors.sortColors(nums);

    }
}
