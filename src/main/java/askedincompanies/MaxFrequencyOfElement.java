package askedincompanies;

public class MaxFrequencyOfElement {

    int maxFrequencySolution1(int arr[], int element) {
        int start = 0;
        int end = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element && end == -1) {
                start = i;
                end=i;
            } else if (arr[i] == element && end != -1) {
                end=i;
            } else if (end > start && arr[i] != element) {
                break;
            }

        }
        return end - start+1;
    }

    public static void main(String[] args) {
        MaxFrequencyOfElement maxFrequencyOfElement = new MaxFrequencyOfElement();
        System.out.println(maxFrequencyOfElement.maxFrequencySolution1(new int[]{2,1, 1, 1, 1,2}, 1));
    }
}
