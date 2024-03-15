class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSize = Math.min(m, n);
        int result = 0;

        for (int i = 1; i <= maxSize; i++) {
            for (int j = 0; j < m - (i - 1); j++) {
                for (int k = 0; k < n - (i - 1); k++) {
                    boolean satisfied = true;

                    for (int l1 = 0; l1 < i; l1++) {
                        for (int l2 = 0; l2 < i; l2++) {
                            if (matrix[j + l1][k + l2] == 0) {
                                satisfied = false;
                                break;
                            }
                        }
                        if (satisfied == false) {
                            break;
                        }
                    }

                    if (satisfied) {
                        result++;
                    }
                }
            }
        }

        return result;
    }
}