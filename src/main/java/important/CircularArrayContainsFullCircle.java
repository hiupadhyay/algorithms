package important;

import java.util.HashSet;
import java.util.Set;

public class CircularArrayContainsFullCircle {

    public boolean contains(int[] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            int idx = input[i];
            if (idx >= 0 && idx < input.length)
                count++;
            input[i] = -input[i];
        }
        return count == input.length;
    }

    public static void main(String[] args) {
        CircularArrayContainsFullCircle circularArrayContainsFullCircle = new CircularArrayContainsFullCircle();
        System.out.println(circularArrayContainsFullCircle.contains(new int[]{2,3,1,4,0}));
    }
}
