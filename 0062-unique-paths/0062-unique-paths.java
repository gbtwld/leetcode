class Solution {
    public int uniquePaths(int m, int n) {
        /*
        0 1 1 1 1 1 1
        1 2 3 4 5 6 7
        1 3 6 10 15 21 28
        */
        /*
        0 1
        1 2
        1 3
        */
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            arr[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }

        return arr[m - 1][n - 1];
    }
}