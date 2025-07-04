class GameOfLife {
    public int[][] tick(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[][]{};
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int neighbors = countLiveNeighbors(matrix, i, j, rows, cols);
                boolean isAlive = matrix[i][j] == 1;
                
                if (isAlive && (neighbors == 2 || neighbors == 3)) {
                    result[i][j] = 1;
                } else if (!isAlive && neighbors == 3) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = 0;
                }
            }
        }
        
        return result;
    }
    
    private int countLiveNeighbors(int[][] matrix, int row, int col, int rows, int cols) {
        int count = 0;
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                
                int newRow = row + i;
                int newCol = col + j;
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    if (matrix[newRow][newCol] == 1) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
