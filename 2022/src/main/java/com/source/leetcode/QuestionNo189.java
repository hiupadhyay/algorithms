package com.source.leetcode;

public class QuestionNo189 {

    /**
     * @param input
     *
     * @return majorityElement
     * the optimal solution is based on moore's voting algorithm https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
     */
    public int findMajorityElement(int[] input) {
        int majorityElement = input[0];
        int frequencyOfMajorityElement = 1;
        for (int i = 1; i < input.length; i++) {
            if (majorityElement == input[i]) {
                frequencyOfMajorityElement++;
            } else if (frequencyOfMajorityElement == 0) {
                frequencyOfMajorityElement--;

            } else {
                frequencyOfMajorityElement++;
            }
        }
        return majorityElement;
    }
}
