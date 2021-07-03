package askedincompanies;

public class MaxFrequencyOfElement {

    int maxFrequencySolution1(int arr[], int element) {
        int start = 0;
        int end = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element && end == -1) {
                start = i;
                end = i;
            } else if (arr[i] == element && end != -1) {
                end = i;
            } else if (end > start && arr[i] != element) {
                break;
            }

        }
        return end - start + 1;
    }

    int maxFrequencySolution2(int arr[], int element) {
        return findSecondOccurence(arr, element) - findFirstOccurence(arr, element) + 1;
    }

    private int findSecondOccurence(int[] arr, int element) {
        int f = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (arr[mid] <= element) start = mid + 1;
            else end = mid - 1;
            if (arr[mid] == element)
                f = mid;
        }
        return f;
    }

    private int findFirstOccurence(int[] arr, int element) {
        int f = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (arr[mid] >= element) end = mid - 1;
            else start = start + 1;
            if (arr[mid] == element)
                f = mid;
        }
        return f;
    }

    public static void main(String[] args) {
        MaxFrequencyOfElement maxFrequencyOfElement = new MaxFrequencyOfElement();
        System.out.println(maxFrequencyOfElement.maxFrequencySolution1(new int[]{-1, 1, 1, 1, 1, 2}, 1));
        System.out.println(maxFrequencyOfElement.maxFrequencySolution2(new int[]{-1, 1, 1, 1, 1, 2}, 1));

    }
}
