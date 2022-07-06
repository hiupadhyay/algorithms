package practise.askedincompanies;

public class FindingIslands {

    public int findIsland(int[][] input) {
        int count = 0;
        boolean[][] isVisited = new boolean[input.length][input[0].length];

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 1 && !isVisited[i][j]) {
                    markVisited(input, i, j, isVisited);
                    count++;
                }
            }

        }

        return count;
    }

    public void markVisited(int[][] input, int i, int j, boolean[][] isVisited) {

        if (i < 0 || j < 0 || i >= input.length || j >= input[0].length || isVisited[i][j] || input[i][j] == 0)
            return;

        isVisited[i][j] = true;
        //1,1   1,0 ,
        markVisited(input, i, j + 1, isVisited);
        markVisited(input, i, j - 1, isVisited);
        markVisited(input, i - 1, j, isVisited);
        markVisited(input, i + 1, j, isVisited);
        //diagonal.
        markVisited(input, i + 1, j - 1, isVisited);
        markVisited(input, i + 1, j + 1, isVisited);
        markVisited(input, i - 1, j + 1, isVisited);
        markVisited(input, i - 1, j - 1, isVisited);

    }

    public static void main(String[] args) {

        int island[][] = new int[][]{{0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 0}};
        int output = new FindingIslands().findIsland(island);
        System.out.println(output);

    }


}
