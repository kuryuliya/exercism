import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KillerSudokuHelper {

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize, List<Integer> exclude) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> excludeSet = new HashSet<>(exclude != null ? exclude : new ArrayList<>());
        
        generateCombinations(cageSum, cageSize, excludeSet, new ArrayList<>(), 1, result);
        return result;
    }

    List<List<Integer>> combinationsInCage(Integer cageSum, Integer cageSize) {
        return combinationsInCage(cageSum, cageSize, new ArrayList<>());
    }
    
    private void generateCombinations(int targetSum, int size, Set<Integer> exclude, 
                                    List<Integer> current, int start, List<List<Integer>> result) {
        if (current.size() == size) {
            if (sum(current) == targetSum) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        
        for (int i = start; i <= 9; i++) {
            if (!exclude.contains(i) && !current.contains(i)) {
                current.add(i);
                generateCombinations(targetSum, size, exclude, current, i + 1, result);
                current.remove(current.size() - 1);
            }
        }
    }
    
    private int sum(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }
}
