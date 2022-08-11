package com.source.leetcode;

/**
 * Kth Largest Element in an Array
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * <p>
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 */
public class QuestionNo215 {
    /**
     * @param elements
     * @param kth
     * @return
     */
    public int findKthLargestElementUsingDivideAndConquer(int[] elements, int kth) {
        if (elements == null || elements.length == 0 || kth < 0 || kth > elements.length)
            return -1;

        int start = 0;
        int end = elements.length - 1;
        //this is because we assume that our element would magically be sorted and available at this place
        //if it is not present here, we will continue our sorting
        int indexWhereElementWouldBeFound = elements.length - kth;

        while (start < end) {
            //first we will find the pivot element between start and end, pivot element would be such that element on
            //it's left would be less than it and element towards it's right would be greater than it.
            int indexOfPivot = findIndexofPivotElement(elements, start, end);
            if (indexOfPivot < indexWhereElementWouldBeFound) {
                //this means the element we are trying to find is actually towards the right side of Pivot element
                //we should re-find index starting from indexOfPivot+1
                start = indexOfPivot + 1;

            } else if (indexOfPivot > indexWhereElementWouldBeFound) {
                //this means that element we are trying to find is actually towards left of Pivot element
                //we should re-find index ending at indexOfPivot-1 as on or after the index of Pivot everything is greater than
                //what we are trying to find
                end = indexOfPivot - 1;

            } else {
                //condition where we find our element
                return elements[indexOfPivot];
            }

        }
        return elements[start];
    }

    /**
     *
     * @param elements
     * @param kth
     * @return
     */
    public int findKthLargestElementUsingMinHeap(int[] elements, int kth) {

        return -1;
    }


    private int findIndexofPivotElement(int[] elements, int start, int end) {
        int assumedPivot = start;
        //idea is to find two elements one less than pivot one greater than pivot such that pivot stays in middle
        while (start <= end) {
            while (start <= end && elements[start] <= elements[assumedPivot]) start++;
            while (start <= end && elements[end] > elements[assumedPivot]) end--;
            //the above is to scale down the boundaries of search range
            if (start > end) break;
            swap(elements, end, start);

        }
        swap(elements, assumedPivot, end);
        return end;
    }

    private void swap(int[] elements, int end, int start) {
        int temp = 0;
        temp = elements[end];
        elements[end] = elements[start];
        elements[start] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new QuestionNo215().findKthLargestElementUsingDivideAndConquer(new int[]{33, 2, 1, 5, 6, 4, 20}, 3));
    }

}
