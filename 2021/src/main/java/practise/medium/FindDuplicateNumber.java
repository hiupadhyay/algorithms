package practise.medium;

public class FindDuplicateNumber {

    //condition is it will consist of only one unique duplicate.
    public static int findDuplicate(int[] input) {
        if (input.length < 1) return -1;
        int slow = input[0];
        int fast = input[input[0]];
        while (slow != fast) {
            slow = input[slow];
            fast = input[input[fast]];
        }
        fast = 0;
        while (slow != fast) {
            slow = input[slow];
            fast = input[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,2,3,1,1}));
    }
}
