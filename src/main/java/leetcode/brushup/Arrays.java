package leetcode.brushup;

public class Arrays {

    public static void main(String[] args) {
        Problem1920 problem1920 = new Problem1920();
        int[] output = problem1920.buildArray(new int[]{0, 2, 1, 5, 3, 4});
        for (int i : output)
            System.out.print(i + "\t");
    }
}

class Problem1920 {

    /**
     * <a href="https://leetcode.com/problems/build-array-from-permutation/">link</a>
     *
     * @param nums
     * @return
     */
    public int[] buildArray(int[] nums) {
        int[] outputArray = new int[nums.length];
        int j = 0;
        for (int i = 0; i < nums.length; i++)
            outputArray[j++] = nums[nums[i]];
        return outputArray;
    }

}
