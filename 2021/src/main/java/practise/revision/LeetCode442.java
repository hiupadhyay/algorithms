package practise.revision;

import java.util.ArrayList;
import java.util.List;

public class LeetCode442 {


    public List<Integer> allDuplicatesBruteForce(int[] arr) {
        List<Integer> output = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i : arr) {
            //3
            if (output.contains(i)) {
                result.add(i);
            } else {
                output.add(i);
            }
        }
        return result;
    }

    public List<Integer> allDuplicates(int[] arr) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int loc = Math.abs(arr[i]) - 1;
            if (arr[loc] < 0)
                output.add(Math.abs(arr[i]));
            arr[loc] = -arr[loc];
        }
        return output;
    }

    public static void main(String[] args) {
        LeetCode442 leetCode46 = new LeetCode442();
        int arr[] = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        int arr1[] = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(leetCode46.allDuplicates(arr));
        System.out.println(leetCode46.allDuplicatesBruteForce(arr1));

    }
}
