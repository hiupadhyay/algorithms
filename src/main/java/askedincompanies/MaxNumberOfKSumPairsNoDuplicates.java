package askedincompanies;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairsNoDuplicates {

    public int maxNumber(int arr[], int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i) && map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
                count++;
            } else {
                map.put(k - i, map.getOrDefault(k - i, 0) + 1);
            }
        }
        return count;
    }


    public static void main(String[] args) {
        MaxNumberOfKSumPairsNoDuplicates maxNumberOfKSumPairsNoDuplicates=new MaxNumberOfKSumPairsNoDuplicates();
        System.out.print(maxNumberOfKSumPairsNoDuplicates.maxNumber(new int[]{1,2,3,4},5)==2);
        System.out.print(maxNumberOfKSumPairsNoDuplicates.maxNumber(new int[]{3,1,3,4,3},6)==1);

    }
}
