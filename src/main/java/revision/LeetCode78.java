package revision;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {

    public List<List<Integer>> powerSet(int[] input) {
        List<List<Integer>> output = new ArrayList<>();
        output.add(new ArrayList<>());
        for (int value : input) {
            int size = output.size();
            for (int j = 0; j < size; j++) {
                List<Integer> li = new ArrayList<>(output.get(j));
                li.add(value);
                output.add(li);
            }
        }
        return output;
    }

    public List<List<Integer>> powerSetBitWay(int[] input) {
        List<List<Integer>> output = new ArrayList<>();
        int start = 0;
        int end = (int) Math.pow(2, input.length) - 1;
        for (int i = start; i <= end; i++) {
            List<Integer> li = new ArrayList<>();
            int temp = i;
            for (int j = input.length - 1; j >= 0; j--) {
                int lsb = temp % 2;
                temp /= 2;
                if (lsb != 0)
                    li.add(input[j]);
            }
            output.add(li);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        LeetCode78 leetCode78 = new LeetCode78();
        System.out.println(leetCode78.powerSet(input));
        System.out.println(leetCode78.powerSetBitWay(input));
    }
}
