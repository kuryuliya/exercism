import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Matrix {
    private final List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        Set<MatrixCoordinate> saddlePoints = new HashSet<>();
        
        if (values.isEmpty() || values.get(0).isEmpty()) {
            return saddlePoints;
        }
        
        int rows = values.size();
        int cols = values.get(0).size();
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int currentValue = values.get(row).get(col);
                
                // Check if current value is maximum in its row
                boolean isMaxInRow = true;
                for (int c = 0; c < cols; c++) {
                    if (values.get(row).get(c) > currentValue) {
                        isMaxInRow = false;
                        break;
                    }
                }
                
                if (!isMaxInRow) {
                    continue;
                }
                
                // Check if current value is minimum in its column
                boolean isMinInCol = true;
                for (int r = 0; r < rows; r++) {
                    if (values.get(r).get(col) < currentValue) {
                        isMinInCol = false;
                        break;
                    }
                }
                
                if (isMinInCol) {
                    saddlePoints.add(new MatrixCoordinate(row + 1, col + 1));
                }
            }
        }
        
        return saddlePoints;
    }
}
