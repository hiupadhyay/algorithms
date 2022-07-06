package practise.medium;

public class RotateArray {

    public void rotateLeft(int nums[], int k) {
        if (nums.length == 1) return;
        while (k > nums.length)
            k -= nums.length;
        int mid = k - 1;
        int len = nums.length - 1;
        reverse(nums, 0, mid);
        reverse(nums, mid + 1, len);
        reverse(nums, 0, len);
    }

    public void rotateRight(int nums[], int k) {
        if (nums.length == 1) return;
        while (k > nums.length)
            k -= nums.length;
        int mid = nums.length - k - 1;
        int len = nums.length - 1;
        reverse(nums, 0, mid);
        reverse(nums, mid + 1, len);
        reverse(nums, 0, len);

    }

    private void reverse(int[] nums, int low, int high) {
        while (low <= high) {
            int temp = nums[high];
            nums[high] = nums[low];
            nums[low] = temp;
            low++;
            high--;
        }
    }


    private void print(int n[]) {
        for (int i : n)
            System.out.print(i + "\t");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] in = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        RotateArray array = new RotateArray();
        array.rotateRight(in, k);
        array.rotateLeft(in, k);
        //after rotate left and right same time resulting in the input array itself.
        array.print(in);
    }
}
