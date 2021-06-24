package easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {


    public List<List<Integer>> printPascal(int rows) {
        List<List<Integer>> completeTree = new ArrayList<>();
        completeTree.add(new ArrayList<>());
        completeTree.get(0).add(1);

        for (int i = 1; i < rows; i++) {
            List<Integer> prevRows = completeTree.get(i - 1);
            List<Integer> currentTree = new ArrayList<>();
            //first and last element always be 1
            currentTree.add(1);
            for (int j = 1; j < i; j++) {
                currentTree.add(prevRows.get(j - 1) + prevRows.get(j));
            }
            //last
            currentTree.add(1);
            completeTree.add(currentTree);
        }
        return completeTree;
    }


    public static void main(String[] args) {

        System.out.print(new PascalTriangle().printPascal(5));

    }
}
