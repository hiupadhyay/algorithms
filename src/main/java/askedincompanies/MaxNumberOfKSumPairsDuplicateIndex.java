package askedincompanies;

import java.util.HashSet;
import java.util.Set;

public class MaxNumberOfKSumPairsDuplicateIndex {

    public int maxNumber(int arr[], int k) {
        int count = 0;
        Set<Integer> map = new HashSet<>();
        for (int i : arr) {
            map.add(i);
            if (map.contains(k - i)) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        MaxNumberOfKSumPairsDuplicateIndex maxNumberOfKSumPairsNoDuplicates=new MaxNumberOfKSumPairsDuplicateIndex();
        System.out.println(maxNumberOfKSumPairsNoDuplicates.maxNumber(new int[]{4,2,2,4,2},6));

    }
}
