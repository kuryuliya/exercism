class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        if (stringToVerify == null || stringToVerify.isEmpty()) {
            return false;
        }
        
        String cleaned = stringToVerify.replaceAll("-", "");
        
        if (cleaned.length() != 10) {
            return false;
        }
        
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            char c = cleaned.charAt(i);
            
            if (i == 9) {
                if (c == 'X' || c == 'x') {
                    sum += 10;
                } else if (Character.isDigit(c)) {
                    sum += Character.getNumericValue(c);
                } else {
                    return false;
                }
            } else {
                if (!Character.isDigit(c)) {
                    return false;
                }
                sum += Character.getNumericValue(c) * (10 - i);
            }
        }
        
        return sum % 11 == 0;
    }

}
