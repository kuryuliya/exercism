import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char targetLetter) {
        List<String> diamond = new ArrayList<>();
        
        if (targetLetter == 'A') {
            diamond.add("A");
            return diamond;
        }
        
        int targetIndex = targetLetter - 'A';
        int size = 2 * targetIndex + 1;
        
        for (int row = 0; row < size; row++) {
            StringBuilder line = new StringBuilder();
            
            int distanceFromCenter = Math.abs(row - targetIndex);
            char currentLetter = (char) ('A' + targetIndex - distanceFromCenter);
            
            int leadingSpaces = distanceFromCenter;
            int middleSpaces = size - 2 - 2 * distanceFromCenter;
            
            for (int i = 0; i < leadingSpaces; i++) {
                line.append(" ");
            }
            
            line.append(currentLetter);
            
            if (row != 0 && row != size - 1) {
                for (int i = 0; i < middleSpaces; i++) {
                    line.append(" ");
                }
                line.append(currentLetter);
            }
            
            for (int i = 0; i < leadingSpaces; i++) {
                line.append(" ");
            }
            
            diamond.add(line.toString());
        }
        
        return diamond;
    }

}
