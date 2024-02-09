class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /*
        0 1 1
        1 0 1
        1 1 2
        */
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] arr = new int[m][n];
        
        // 왼쪽 줄 초기화, 중간에 장애물 있으면 그 뒤로 모두 0, 제일 첫 부분에 장애물 있는 경우 때문에 0부터 해야함
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            arr[i][0] = 1;
        }
        // 윗쪽 줄 초기화, 중간에 장애물 있으면 그 뒤로 모두 0
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            arr[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                arr[i][j] = arr[i][j - 1] + arr[i - 1][j];
            }
        }

        return arr[m - 1][n - 1];
    }
}