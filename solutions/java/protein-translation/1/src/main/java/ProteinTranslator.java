import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProteinTranslator {
    private static final Map<String, String> CODON_TO_PROTEIN = new HashMap<>();
    
    static {
        CODON_TO_PROTEIN.put("AUG", "Methionine");
        CODON_TO_PROTEIN.put("UUU", "Phenylalanine");
        CODON_TO_PROTEIN.put("UUC", "Phenylalanine");
        CODON_TO_PROTEIN.put("UUA", "Leucine");
        CODON_TO_PROTEIN.put("UUG", "Leucine");
        CODON_TO_PROTEIN.put("UCU", "Serine");
        CODON_TO_PROTEIN.put("UCC", "Serine");
        CODON_TO_PROTEIN.put("UCA", "Serine");
        CODON_TO_PROTEIN.put("UCG", "Serine");
        CODON_TO_PROTEIN.put("UAU", "Tyrosine");
        CODON_TO_PROTEIN.put("UAC", "Tyrosine");
        CODON_TO_PROTEIN.put("UGU", "Cysteine");
        CODON_TO_PROTEIN.put("UGC", "Cysteine");
        CODON_TO_PROTEIN.put("UGG", "Tryptophan");
        CODON_TO_PROTEIN.put("UAA", "STOP");
        CODON_TO_PROTEIN.put("UAG", "STOP");
        CODON_TO_PROTEIN.put("UGA", "STOP");
    }

    List<String> translate(String rnaSequence) {
        List<String> proteins = new ArrayList<>();
        if (rnaSequence.isEmpty()) {
            return proteins;
        }
        boolean stopFound = false;
        int i = 0;
        while (i + 3 <= rnaSequence.length()) {
            String codon = rnaSequence.substring(i, i + 3);
            if (!CODON_TO_PROTEIN.containsKey(codon)) {
                throw new IllegalArgumentException("Invalid codon");
            }
            String protein = CODON_TO_PROTEIN.get(codon);
            if ("STOP".equals(protein)) {
                stopFound = true;
                break;
            }
            proteins.add(protein);
            i += 3;
        }
        // If there are leftover nucleotides and no STOP was found, it's an error
        if (!stopFound && i < rnaSequence.length()) {
            throw new IllegalArgumentException("Invalid codon");
        }
        return proteins;
    }
}
