class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length, count = 0;
        char[][] matrix = new char[m][];

        for (int i = 0; i < m; i++) {
            matrix[i] = strs[i].toCharArray();
        }
        int n = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if(!isSort(matrix,i))count++;
        }

        return count;
    }

    private boolean isSort(char[][] mat,int col){
        for (int i = 0; i < mat.length - 1; i++) {
            if (mat[i][col] > mat[i + 1][col]) {
                return false;
            }
        }
        return true;
    }
}