package important;

/**
 * Given an integer, re-arrange the integer such that first and last digit will be at first and second,
 * second and second last digit will be at third and fourth position from left of the re-arranges integer
 * and so on.
 * Example:
 * Input -> 12345678, Output -> 18273645
 * Input -> 1234567, Output -> 1726354
 */
public class RearrangeIntegers {

    public int[] reArrange(int[] input) {
        int[] output = new int[input.length];
        int start = 0;
        int end = input.length - 1;
        int i = 0;
        while (start < end) {
            output[i] = input[start];
            output[i + 1] = input[end];
            start++;
            end--;
            i = i + 2;

        }
        if (start == end) {
            output[i] = input[start];
        }
        return output;
    }

    public static void main(String[] args) {

        RearrangeIntegers rearrangeIntegers = new RearrangeIntegers();
        int[] output = rearrangeIntegers.reArrange(new int[]{1, 2, 3, 4, 5, 6, 7,8});
        for (int i : output) {
            System.out.print(i);
        }
    }
}
