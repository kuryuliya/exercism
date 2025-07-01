import java.util.HashSet;
import java.util.Set;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        if (phrase == null || phrase.isEmpty()) {
            return true;
        }
        
        Set<Character> seenLetters = new HashSet<>();
        
        for (char c : phrase.toCharArray()) {
            char lowerC = Character.toLowerCase(c);
            
            // Skip spaces and hyphens
            if (lowerC == ' ' || lowerC == '-') {
                continue;
            }
            
            // Check if letter has been seen before
            if (seenLetters.contains(lowerC)) {
                return false;
            }
            
            seenLetters.add(lowerC);
        }
        
        return true;
    }

}
