package medium;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.print(ContainerWithMostWater.maxArea(height));
    }

    private static int maxArea(int[] height) {
        int area = 0;
        int output = Integer.MIN_VALUE;
        int low = 0;
        int high = height.length - 1;
        while (low <= high) {
            area = Math.min(height[low], height[high]) * (high - low);
            output = Math.max(area, output);
            if (height[low] >= height[high]) {
                high--;
            } else {
                low++;
            }
        }
        return output;
    }
}
