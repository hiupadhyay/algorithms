package revision;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCode11 {
    /**
     * Trapping rain water....
     * @param args
     */
    public static void main(String[] args) {
        int [] height = new int []{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int start=0;
        int end=height.length-1;
        int maxArea=Integer.MIN_VALUE;

        while(start<=end)
        {
            int area=Math.min(height[start],height[end]) * (end-start);
            maxArea=Math.max(area,maxArea);
            if(height[start]>=height[end])
            {
                end--;
            }
            else
            {
                start++;
            }
        }
        return maxArea;
    }


}
