import java.util.HashSet;
import java.util.Set;

public class PangramChecker {

    public boolean isPangram(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        
        Set<Character> letters = new HashSet<>();
        
        for (char c : input.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                letters.add(c);
            }
        }
        
        return letters.size() == 26;
    }

}
