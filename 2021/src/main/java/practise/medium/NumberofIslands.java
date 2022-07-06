package practise.medium;


public class NumberofIslands {

    int findNumberOfIslands(int[][] input) {
        int count = 0;
        boolean[][] isVisited = new boolean[input.length][input[0].length];
        for (int i = 0; i < input.length; i++)
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 1 && !isVisited[i][j]) {
                    findIslands(input, i, j, isVisited);
                    count++;
                }
            }
        return count;
    }

    private void findIslands(int[][] input, int i, int j, boolean[][] isVisited) {
        if (i < 0 || j < 0 || i >= input.length ||
                j >= input[0].length || isVisited[i][j] || input[i][j] == 0) {
            return;
        }

        isVisited[i][j] = true;
        findIslands(input, i, j + 1, isVisited);
        findIslands(input, i, j - 1, isVisited);
        findIslands(input, i - 1, j, isVisited);
        findIslands(input, i + 1, j, isVisited);
    }


    public static void main(String[] args) {
        int[][] in = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        System.out.print(new NumberofIslands().findNumberOfIslands(in));

    }
}
