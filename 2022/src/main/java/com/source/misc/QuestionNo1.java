package com.source.misc;

/**
 * Question: In a toy factory Human and Dog are manufactured, Human has two legs, Dog has Fours legs.
 * You are asked to write a program that can tell you no of possible ways the legs can be used to create Human or Dogs or both Human and dogs.
 * For Example: 4 legs can create 2 Humans and 1 Dog thus have two possible ways
 * we have to return array having all possible ways.
 * Sample Input [ 4, 5, 2]
 * Sample Output[ 2, 0, 1]
 * Sample Input [ 4, 5, 6]
 * Sample Output [ 2, 0, 2]
 * sAMPLE input [ 10, 11, 12]
 * Sample Output [ 3, 0, 4] => 3 i.e  5 Humans or 1 Dogs , 2 human, 3 Dogs, 1 Human
 */
public class QuestionNo1 {

    public int[] findNoOfPossibleWays(int[] legsArray) {
        int[] output = new int[legsArray.length];
        int j = 0;
        for (int legs : legsArray) {
            if (legs % 2 != 0) {
                output[j++] = 0;
            } else {
                output[j++] = 1 + legs / 4;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        QuestionNo1 questionNo1 = new QuestionNo1();
        final int[] result = questionNo1.findNoOfPossibleWays(new int[]{4, 5, 2});
        for (int i : result) {
            System.out.print(i + " ,");
        }
    }
}
