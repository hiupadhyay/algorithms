package practise.important;

public class MaxSumSubArrays {


    public static void main(String[] args) {
        int[] in = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.print(new MaxSumSubArrays().getMaxSumOfSubArray(in));
    }

    private int getMaxSumOfSubArray(int[] in) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i : in) {
            sum += i;
            maxSum = Math.max(maxSum, sum);
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}
